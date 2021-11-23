package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.PaymentMethode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodeRepo extends JpaRepository<PaymentMethode,Long> {
    PaymentMethode getById(Long id);
}
