package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.ServiceType;
import com.vaibhav.sec.repo.ServiceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/serviceType")
public class ServiceTypeController {
    @Autowired
    ServiceTypeRepo serviceTypeRepo;
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity( @PathVariable Long organizationId){
        return ResponseEntity.ok(serviceTypeRepo.findAll());
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody ServiceType serviceType){
        return ResponseEntity.ok(serviceTypeRepo.save(serviceType));
    }
}
