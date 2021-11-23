package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.TimeWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeWorkRepository extends JpaRepository<TimeWork,Long> {
     TimeWork getById(Long id);
     List<TimeWork> getByWeek(String week);
     Boolean existsByWeek(String week);
     void removeByWeek(String week);
     TimeWork getByWeekAndDay(String week,String day);

}
