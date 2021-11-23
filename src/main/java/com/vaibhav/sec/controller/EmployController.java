package com.vaibhav.sec.controller;

import com.vaibhav.sec.exception.AppException;
import com.vaibhav.sec.model.Employ;
import com.vaibhav.sec.model.Role;
import com.vaibhav.sec.model.User;
import com.vaibhav.sec.repo.EmployRepository;
import com.vaibhav.sec.repo.FileStorageService;
import com.vaibhav.sec.repo.RoleRepo;
import com.vaibhav.sec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import payloads.SignUpRequest;

import java.util.Collections;

@RestController
@RequestMapping("/api/employ")
public class EmployController {
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    EmployRepository employRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthController authController;
    @Autowired
    RoleRepo rolesRepository;
    @Autowired
    UserRepo userRepository;


    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEmploys(@PathVariable Long organizationId){
        return ResponseEntity.ok(employRepository.findAll());
    }
    @PostMapping(value = "/update/{organizationId}")
    public ResponseEntity<?> updateEmploys(@RequestBody Employ employ,@PathVariable Long organizationId){
        return ResponseEntity.ok(employRepository.save(employ));
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> addEmploys(@PathVariable Long id,@PathVariable Long organizationId){
        employRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> sendMessage(@RequestBody Employ employ,@PathVariable Long organizationId) {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setPassword(passwordEncoder.encode(employ.getPassword()));
        signUpRequest.setEmail(employ.getEmail());
        signUpRequest.setRoleId(employ.getRoleId());
        signUpRequest.setUsername(employ.getPhone());
        employ.setRoleName(rolesRepository.findById(employ.getRoleId()).get().getName());
        User user = new User( signUpRequest.getUsername(),signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword(), organizationId);
        Role userRole = rolesRepository.findById(signUpRequest.getRoleId()).orElseThrow(() -> new AppException("User Role not set."));
        user.setRoles(Collections.singleton(userRole));
        User result = userRepository.save(user);
        employ.setPassword(passwordEncoder.encode(employ.getPassword()));
        employ.setUserId(result.getId());
        employRepository.save(employ);
        return ResponseEntity.ok(employ);
    }

    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        return fileDownloadUri;
    }

}
