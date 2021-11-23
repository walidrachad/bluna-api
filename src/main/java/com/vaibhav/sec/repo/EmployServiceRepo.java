package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.EmployService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployServiceRepo extends JpaRepository<EmployService,Long> {
    List<EmployService> getByEmployId(Long id);
    List<EmployService> getByServiceId(Long id);
}
