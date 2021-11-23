package com.vaibhav.sec.controller;


import java.net.URI;
import java.util.*;
import javax.validation.Valid;
import com.vaibhav.sec.exception.AppException;
import com.vaibhav.sec.model.*;
import com.vaibhav.sec.repo.*;
import com.vaibhav.sec.responce.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.vaibhav.sec.security.JwtTokenProvider;
import payloads.ApiResponse;
import payloads.JwtAuthenticationResponse;
import payloads.LoginRequest;
import payloads.SignUpRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepo userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtTokenProvider tokenProvider;
    @Autowired
	RoleRepo rolesRepository;
	@Autowired
	EmployRepository employRepository;
	@Autowired
	ClientRepository clientRepository;
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
        User user = userRepository.findByUsername(loginRequest.getUsername());
		UserResponse response = new UserResponse();
		JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(jwt);
		List<Role> mainList = new ArrayList<Role>();
		mainList.addAll(user.getRoles());
		response.setEmail(user.getEmail());
		response.setId(user.getId());
		response.setName(user.getName());
		response.setOrganizationId(user.getOrganizationId());
		response.setToken(jwtAuthenticationResponse.getTokenType()+jwtAuthenticationResponse.getAccessToken());
		response.setUsername(user.getUsername());
		if(mainList.get(0).getName().contains("user")){
			response.setRole(mainList.get(0));
			response.setUser(clientRepository.getByPhone(user.getUsername()));
		}else {
			response.setUser(employRepository.getByPhone(user.getUsername()));
			response.setRole(mainList.get(0));
		}
		return ResponseEntity.ok(response);
	}
	@PostMapping("/register/{organizationId}")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest,@PathVariable Long organizationId) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}
		User user = new User( signUpRequest.getUsername(),signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword(), organizationId);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = rolesRepository.findById(signUpRequest.getRoleId()).orElseThrow(() -> new AppException("User Role not set."));
		user.setRoles(Collections.singleton(userRole));
		User result = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();
		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}
	@GetMapping(value = "/{organizationId}")
	public ResponseEntity<?> getUsers(@PathVariable Long organizationId){
		return ResponseEntity.ok(userRepository.findAll());
	}
	@GetMapping(value="/getUserRole")
	public ResponseEntity<?> getUserRole(){
		return ResponseEntity.ok(rolesRepository.findByName("user").get().getId());
	}
}
