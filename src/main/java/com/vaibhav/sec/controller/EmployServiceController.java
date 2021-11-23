package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.EmployService;
import com.vaibhav.sec.repo.EmployServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employServices")
public class EmployServiceController {

    @Autowired
    EmployServiceRepo employServiceRepo;
    @PostMapping(value = "/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody EmployService employService,@PathVariable Long organizationId){
        return ResponseEntity.ok(employServiceRepo.save(employService));
    }
}
