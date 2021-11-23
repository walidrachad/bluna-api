package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.ClientInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientInvoiceRepo extends JpaRepository<ClientInvoice,Long> {
    ClientInvoice getByClientIdAndOrganizationId(Long id,Long organizationId);
}
