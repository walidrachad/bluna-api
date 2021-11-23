package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceCategoryRepo extends JpaRepository<ServiceCategory,Long> {
    List<ServiceCategory> getByServiceType(Long id);
}
