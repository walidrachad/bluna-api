package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.ServiceCategory;
import com.vaibhav.sec.repo.ServiceCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/serviceCategory")
public class ServiceCategoryController {
    @Autowired
    ServiceCategoryRepo serviceCategoryRepo;

    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity( @PathVariable Long organizationId){
        return ResponseEntity.ok(serviceCategoryRepo.findAll());
    }

    @GetMapping(value = "/category/{id}/{organizationId}")
    public ResponseEntity<?> getEntityByCategory(@PathVariable Long id,@PathVariable Long organizationId){
        return ResponseEntity.ok(serviceCategoryRepo.getByServiceType(id));
    }

    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody ServiceCategory serviceCategory,@PathVariable Long organizationId){
        return ResponseEntity.ok(serviceCategoryRepo.save(serviceCategory));
    }
}

