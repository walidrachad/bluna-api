package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.EmployRole;
import com.vaibhav.sec.model.Role;
import com.vaibhav.sec.repo.EmployRoleRepo;
import com.vaibhav.sec.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employ_role")
public class EmployRoleController {
    @Autowired
    RoleRepo employRoleRepository;
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getAll(@PathVariable Long organizationId){
        return ResponseEntity.ok(employRoleRepository.findAll());
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Role employRole,@PathVariable Long organizationId){
        return ResponseEntity.ok(employRoleRepository.save(employRole));
    }
    @PostMapping(value = "/update/{organizationId}")
    public ResponseEntity<?> updateEntity(@RequestBody Role employRole,@PathVariable Long organizationId){
        return ResponseEntity.ok(employRoleRepository.save(employRole));
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        employRoleRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
