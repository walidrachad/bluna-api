package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepo extends JpaRepository<ServiceType,Long> {
}
