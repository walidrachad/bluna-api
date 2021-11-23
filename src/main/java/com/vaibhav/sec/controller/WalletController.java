package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.Wallet;
import com.vaibhav.sec.repo.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    @Autowired
    WalletRepository walletRepository;

    @PostMapping(value = "/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Wallet wallet,@PathVariable Long organizationId){
        return ResponseEntity.ok(walletRepository.save(wallet));
    }

}
