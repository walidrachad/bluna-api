package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.EmployPermission;
import com.vaibhav.sec.model.Permission;
import com.vaibhav.sec.repo.EmployPermissionRepository;
import com.vaibhav.sec.repo.EmployRepository;
import com.vaibhav.sec.repo.PermissionRepository;
import com.vaibhav.sec.responce.PermissionRequest;
import com.vaibhav.sec.responce.PermissionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    EmployRepository employRepository;
    @Autowired
    EmployPermissionRepository employPermissionRepository;
    @PostMapping(value = "/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Permission permission,@PathVariable Long organizationId){
        return ResponseEntity.ok(permissionRepository.save(permission));
    }
    @GetMapping(value = "/getByEmploy/{id}/{organizationId}")
    public ResponseEntity<?> getAllByEmployEntity(@PathVariable Long id,@PathVariable Long organizationId){
        employPermissionRepository.getByEmployId(id);
        List<PermissionResponse> permissionResponseList= new ArrayList<>();
        employPermissionRepository.getByEmployId(id).forEach(data->{
            PermissionResponse permissionResponse=new PermissionResponse();
            permissionResponse.setId(data.getId());
            permissionResponse.setEmployId(employRepository.getById(data.getEmployId()));
            permissionResponse.setPermission(permissionRepository.getById(data.getPermissionId()));
            permissionResponseList.add(permissionResponse);
        });
        return ResponseEntity.ok(permissionResponseList);
    }
    @GetMapping(value = "/getByPermission/{id}/{organizationId}")
    public ResponseEntity<?> getAllByPermission(@PathVariable Long id,@PathVariable Long organizationId){
        employPermissionRepository.getByEmployId(id);
        List<PermissionResponse> permissionResponseList= new ArrayList<>();
        employPermissionRepository.getByPermissionId(id).forEach(data->{
            PermissionResponse permissionResponse=new PermissionResponse();
            permissionResponse.setId(data.getId());
            permissionResponse.setEmployId(employRepository.getById(data.getEmployId()));
            permissionResponse.setPermission(permissionRepository.getById(data.getPermissionId()));
            permissionResponseList.add(permissionResponse);
        });
        return ResponseEntity.ok(permissionResponseList);
    }
    @PostMapping(value = "/addToEmploy/{organizationId}")
    public ResponseEntity<?> addToEmploy(@RequestBody PermissionRequest permissionRequest,@PathVariable Long organizationId){
        EmployPermission employPermission= new EmployPermission();
        employPermission.setPermissionId(permissionRequest.getPermissionId());
        employPermission.setEmployId(permissionRequest.getEmployId());
        return ResponseEntity.ok(employPermissionRepository.save(employPermission));
    }
    @DeleteMapping("/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        employPermissionRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
