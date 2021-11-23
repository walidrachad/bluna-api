package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {}
