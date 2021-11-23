package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.PaymentMethode;
import com.vaibhav.sec.repo.PaymentMethodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paymentMethode")
public class PaymentMethodeController {
    @Autowired
    PaymentMethodeRepository paymentMethodeRepository;
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity(@PathVariable Long organizationId){
        return ResponseEntity.ok(paymentMethodeRepository.findAll());
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody PaymentMethode paymentMethode,@PathVariable Long organizationId){
        return ResponseEntity.ok(paymentMethodeRepository.save(paymentMethode));
    }

}
