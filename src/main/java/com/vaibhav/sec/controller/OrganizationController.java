package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.Organization;
import com.vaibhav.sec.repo.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    OrganizationRepository organizationRepository;

    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity(@PathVariable Long organizationId){
        return ResponseEntity.ok(organizationRepository.findAll());
    }
    @GetMapping(value = "/get/{organizationId}")
    public ResponseEntity<?> getEntityById(@PathVariable Long organizationId){
        return ResponseEntity.ok(organizationRepository.getById(organizationId));
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> addEntity(@RequestBody Organization appointment){
        return ResponseEntity.ok(organizationRepository.save(appointment));
    }
    @PostMapping(value = "/update/{organizationId}")
    public ResponseEntity<?> updateEntity(@RequestBody Organization appointment,@PathVariable Long organizationId){
        return ResponseEntity.ok(organizationRepository.save(appointment));
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        organizationRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }

}
