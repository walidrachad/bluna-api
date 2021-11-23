package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel,Long> {
    PaymentModel getByUsernameAndPasswordAndOrganizationId(String username,String password,Long id);
    PaymentModel getById(Long id);
}
