package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Employ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employ,Long> {
    Employ getByPhone(String phone);
    Employ getById(Long phone);
}
