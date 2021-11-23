package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.AffectationTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectationTimeWorkRepo extends JpaRepository<AffectationTime,Long> {
      List<AffectationTime> getByEmployId(Long id);
}
