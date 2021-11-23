package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization getById(Long id);
}
