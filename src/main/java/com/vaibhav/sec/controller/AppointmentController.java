package com.vaibhav.sec.controller;


import com.vaibhav.sec.model.Appointment;
import com.vaibhav.sec.model.Services;
import com.vaibhav.sec.repo.AppointmentRepository;
import com.vaibhav.sec.repo.ClientRepository;
import com.vaibhav.sec.repo.EmployRepository;
import com.vaibhav.sec.repo.ServiceRepository;
import com.vaibhav.sec.responce.AppointmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    EmployRepository employRepository;
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity(@PathVariable Long organizationId){
        List<AppointmentResponse> responseList = new ArrayList<>();
        appointmentRepository.findAll().forEach(element->{
            AppointmentResponse response= new AppointmentResponse();
            Services services = serviceRepository.findById(element.getServiceId()).get();
            response.setId(element.getId());
            response.setClient(clientRepository.getById(element.getClientId()));
            response.setContent(services.getDescription());
            response.setTitle(services.getName());
            response.setJour(element.getJour());
            response.setStart(element.getStart());
            response.setEnd(element.getEnd());
            response.setWeek(element.getWeek());
            response.setRappel(Boolean.valueOf(element.getRappel()));
            response.setEmploy(employRepository.getById(element.getEmployId()));
            responseList.add(response);
        });
        return ResponseEntity.ok(responseList);
    }
    @GetMapping(value = "/getByWeek/{week}/{organizationId}")
    public ResponseEntity<?> getByWeekEntity(@PathVariable String week,@PathVariable Long organizationId){
        List<AppointmentResponse> responseList = new ArrayList<>();
        appointmentRepository.getByWeek(week).forEach(element->{
            AppointmentResponse response= new AppointmentResponse();
            Services services = serviceRepository.findById(element.getServiceId()).get();
            response.setId(element.getId());
            response.setClient(clientRepository.getById(element.getClientId()));
            response.setContent(services.getDescription());
            response.setTitle(services.getName());
            response.setJour(element.getJour());
            response.setStart(element.getStart());
            response.setEnd(element.getEnd());
            response.setWeek(element.getWeek());
            response.setRappel(Boolean.valueOf(element.getRappel()));
            response.setEmploy(employRepository.getById(element.getEmployId()));
            responseList.add(response);
        });
        return ResponseEntity.ok(responseList);
    }
    @GetMapping(value = "/getByClient/{id}/{organizationId}")
    public ResponseEntity<?> getByClient(@PathVariable Long id,@PathVariable Long organizationId){
        List<AppointmentResponse> responseList = new ArrayList<>();
        appointmentRepository.getByClientId(id).forEach(element->{
            AppointmentResponse response= new AppointmentResponse();
            Services services = serviceRepository.findById(element.getServiceId()).get();
            response.setId(element.getId());
            response.setClient(clientRepository.getById(element.getClientId()));
            response.setContent(services.getDescription());
            response.setTitle(services.getName());
            response.setJour(element.getJour());
            response.setStart(element.getStart());
            response.setEnd(element.getEnd());
            response.setWeek(element.getWeek());
            response.setRappel(Boolean.valueOf(element.getRappel()));
            response.setEmploy(employRepository.getById(element.getEmployId()));
            responseList.add(response);
        });
        return ResponseEntity.ok(responseList);
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Appointment appointment,@PathVariable Long organizationId){
        return ResponseEntity.ok(appointmentRepository.save(appointment));
    }
    @PostMapping(value = "/update/{organizationId}")
    public ResponseEntity<?> updateEntity(@RequestBody Appointment appointment,@PathVariable Long organizationId){
        return ResponseEntity.ok(appointmentRepository.save(appointment));
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        appointmentRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
    @GetMapping(value = "/getByEmploy/{employId}/week/{week}/{organizationId}")
    public ResponseEntity<?> getByEmploy(@PathVariable String week,@PathVariable Long employId,@PathVariable Long organizationId){
        List<AppointmentResponse> responseList = new ArrayList<>();
        appointmentRepository.getByWeekAndEmployId(week,employId).forEach(element->{
            AppointmentResponse response= new AppointmentResponse();
            Services services = serviceRepository.findById(element.getServiceId()).get();
            response.setId(element.getId());
            response.setClient(clientRepository.getById(element.getClientId()));
            response.setContent(services.getDescription());
            response.setTitle(services.getName());
            response.setJour(element.getJour());
            response.setStart(element.getStart());
            response.setEnd(element.getEnd());
            response.setWeek(element.getWeek());
            response.setRappel(Boolean.valueOf(element.getRappel()));
            response.setEmploy(employRepository.getById(element.getEmployId()));
            responseList.add(response);
        });
        return ResponseEntity.ok(responseList);
    }

}
