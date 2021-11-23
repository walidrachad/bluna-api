package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.Available;
import com.vaibhav.sec.repo.AvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@RestController
@RequestMapping("/api/available")

public class AvailableController {
    @Autowired
    AvailableRepository availableRepository;
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Available available,@PathVariable Long organizationId){
        return ResponseEntity.ok(availableRepository.save(available));
    }
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity(@PathVariable Long organizationId){
        LocalDate ld = LocalDate.of(2014, Month.JUNE, 12);
        System.out.println(ld);
        ld = ld.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(ld);
        return ResponseEntity.ok(availableRepository.findAll());
    }

}
