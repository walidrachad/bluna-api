package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    Permission getById(Long id);
}
