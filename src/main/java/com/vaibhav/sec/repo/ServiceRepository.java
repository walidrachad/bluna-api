package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Services,Long> {
    List<Services> getByCategoryId(Long id);
    List<Services> getByTypeId(Long id);
    Services getById(Long id);
}
