package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.Available;
import com.vaibhav.sec.model.TimeModuleEmploy;
import com.vaibhav.sec.model.TimeWorkModul;
import com.vaibhav.sec.repo.AvailableRepository;
import com.vaibhav.sec.repo.TimeModuleEmployRepo;
import com.vaibhav.sec.repo.TimeWorkModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/timeWorkModule")
public class TimeWorkModuleController {
    @Autowired
    TimeWorkModuleRepo timeWorkModuleRepo;
    @Autowired
    AvailableRepository availableRepository;
    @Autowired
    TimeModuleEmployRepo timeModuleEmployRepo;
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody TimeWorkModul timeWorkModul,@PathVariable Long organizationId){
        Available available =availableRepository.getById(timeWorkModul.getAvailableId());
        timeWorkModul.setAvailable(Collections.singleton(available));
        return ResponseEntity.ok(timeWorkModuleRepo.save(timeWorkModul));
    }
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity( @PathVariable Long organizationId){
        return ResponseEntity.ok(timeWorkModuleRepo.findAll());
    }

    @GetMapping(value = "/getByEmploy/{id}/{organizationId}")
    public ResponseEntity<?> getEntityByEmploy(@PathVariable Long id,@PathVariable Long organizationId){
        List<TimeModuleEmploy> timeModuleEmploy= timeModuleEmployRepo.getByEmployId(id);
        if(timeModuleEmploy.isEmpty()){
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(timeWorkModuleRepo.findById(timeModuleEmploy.get(0).getTimeWorkModuleId()));
    }

    @PostMapping(value = "/setModuleToEmploy/{organizationId}")
    public ResponseEntity<?> setModuleToEmploy(@RequestBody TimeModuleEmploy timeModuleEmploy,@PathVariable Long organizationId){
        timeModuleEmployRepo.getByEmployId(timeModuleEmploy.getEmployId()).forEach(data->{
            timeModuleEmployRepo.deleteById(data.getId());
        });
        return ResponseEntity.ok(timeWorkModuleRepo.findById(timeModuleEmployRepo.save(timeModuleEmploy).getEmployId()));
    }
}
