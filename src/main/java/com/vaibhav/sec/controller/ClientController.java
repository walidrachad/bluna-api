package com.vaibhav.sec.controller;

import com.vaibhav.sec.exception.AppException;
import com.vaibhav.sec.model.Client;
import com.vaibhav.sec.model.Role;
import com.vaibhav.sec.model.User;
import com.vaibhav.sec.repo.AppointmentRepository;
import com.vaibhav.sec.repo.ClientRepository;
import com.vaibhav.sec.repo.RoleRepo;
import com.vaibhav.sec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import payloads.SignUpRequest;

import java.util.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepository;
    @Autowired
    RoleRepo rolesRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Client client,@PathVariable Long organizationId){
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setPassword(passwordEncoder.encode(client.getPassword()));
        signUpRequest.setEmail(client.getEmail());
        signUpRequest.setRoleId(client.getRoleId());
        signUpRequest.setUsername(client.getPhone());
        User user = new User(signUpRequest.getUsername(),signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword(), organizationId);
        Role userRole = rolesRepository.findById(signUpRequest.getRoleId()).orElseThrow(() -> new AppException("User Role not set."));
        user.setRoles(Collections.singleton(userRole));
        User result = userRepository.save(user);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setUserId(result.getId());
        return ResponseEntity.ok(clientRepository.save(client));
    }
    @PostMapping(value = "/addFromAdmin/{organizationId}")
    public ResponseEntity<?> addFromAdmin(@RequestBody Client client,@PathVariable Long organizationId){
        return ResponseEntity.ok(clientRepository.save(client));
    }
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity(@PathVariable Long organizationId){
        return ResponseEntity.ok(clientRepository.findAll());
    }
    @GetMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        clientRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
    @GetMapping(value = "/getByGender/{organizationId}")
    public ResponseEntity<?> getByGender(@PathVariable String gander,@PathVariable Long organizationId){
        return ResponseEntity.ok(clientRepository.getByGender(gander));
    }
    @GetMapping(value = "/getByDate/{date}/{organizationId}")
    public ResponseEntity<?> getByDate(@PathVariable String date,@PathVariable Long organizationId){
        return ResponseEntity.ok(clientRepository.getByDateOfbrithContaining(date));
    }
    @GetMapping(value = "/getByDate/{week}/{organizationId}")
    public ResponseEntity<?> getByLastVisit(@PathVariable String week,@PathVariable Long organizationId) {
        Set<Client> clientList = new HashSet<>();
        appointmentRepository.getByWeek(week).forEach(element->{
            clientList.add(clientRepository.getById(element.getClientId()));
        });
        return ResponseEntity.ok(clientList);
    }
}
