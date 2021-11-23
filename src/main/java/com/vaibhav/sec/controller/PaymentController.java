package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.PaymentMethode;
import com.vaibhav.sec.model.PaymentModel;
import com.vaibhav.sec.repo.PaymentMethodeRepo;
import com.vaibhav.sec.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentMethodeRepo paymentMethodeRepo;

    @PostMapping(value = "/login/{organizationId}")
    public ResponseEntity<?> login(@RequestBody PaymentModel paymentModel,@PathVariable Long organizationId){
        PaymentModel paymentModel1 =paymentRepository.getByUsernameAndPasswordAndOrganizationId(paymentModel.getUsername(),paymentModel.getPassword(),organizationId);
        paymentModel1.setToken(UUID.randomUUID().toString().replace("-", ""));
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        paymentModel1.setDate(formatter.format(calendar.getTime()));
        paymentRepository.save(paymentModel1);
        return ResponseEntity.ok(paymentModel1);
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody PaymentModel paymentModel,@PathVariable Long organizationId){
        return ResponseEntity.ok(paymentRepository.save(paymentModel));
    }
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getAllEntity(@PathVariable Long organizationId){
        return ResponseEntity.ok(paymentRepository.findAll());
    }

    @PostMapping(value = "/addPaymentMethode/{organizationId}")
    public ResponseEntity<?> addPaymentMethode(@RequestBody PaymentMethode paymentMethode,@PathVariable Long organizationId){
        return ResponseEntity.ok(paymentMethodeRepo.save(paymentMethode));
    }
    @GetMapping(value = "/getAllMethode/{organizationId}")
    public ResponseEntity<?> getAllMethode(@PathVariable Long organizationId){
        return ResponseEntity.ok(paymentMethodeRepo.findAll());
    }
}
