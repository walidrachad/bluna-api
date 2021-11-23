package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.TimeModuleEmploy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeModuleEmployRepo extends JpaRepository<TimeModuleEmploy,Long> {
    List<TimeModuleEmploy> getByEmployId(Long id);
    Boolean deleteByEmployId(Long id);
}
