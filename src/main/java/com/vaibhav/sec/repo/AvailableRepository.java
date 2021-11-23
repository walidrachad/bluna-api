package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Available;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableRepository extends JpaRepository<Available,Long> {
    Available getById(Long id);
}
