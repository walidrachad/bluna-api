package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Weeks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepository extends JpaRepository<Weeks,Long> {
    Weeks getByWeek(String week);
}
