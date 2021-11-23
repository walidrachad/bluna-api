package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.EmployPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployPermissionRepository extends JpaRepository<EmployPermission,Long> {
    List<EmployPermission> getByEmployId(Long id);
    List<EmployPermission> getByPermissionId(Long id);

}
