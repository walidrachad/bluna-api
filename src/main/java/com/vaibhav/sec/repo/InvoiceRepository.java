package com.vaibhav.sec.repo;


import com.vaibhav.sec.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    List<Invoice> getByUserId(Long id);
    List<Invoice> getByDateContaining(String date);
    List<Invoice> getByStatus(String status);

}
