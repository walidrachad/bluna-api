package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Times;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesRepository extends JpaRepository<Times,Long>{
    List<Times> getByTimeWorkId(Long id);
}
