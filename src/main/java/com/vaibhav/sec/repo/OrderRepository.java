package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> getByInvoiceId(Long id);
}
