package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeRepository extends JpaRepository<Time,Long> {
    List<Time> getByTimesId(Long id);
}
