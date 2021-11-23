package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.AffectationServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectationServicesRepo extends JpaRepository<AffectationServices,Long> {
    List<AffectationServices> getByAdminServiceId(Long id);
    List<AffectationServices> getByUserServicesId(Long id);
    List<AffectationServices> getByUserServicesIdAndAdminServiceId(Long userId,Long adminId);
}
