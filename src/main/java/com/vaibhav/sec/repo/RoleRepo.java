package com.vaibhav.sec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaibhav.sec.model.Role;
import com.vaibhav.sec.model.RoleName;
import java.util.*;
@Repository
public interface RoleRepo extends JpaRepository<Role , Long>{
	Optional<Role> findByName(String roleName);
	Optional<Role> findById(Long roleName);
}
