package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.HistoricalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricalAppointmentRepo extends JpaRepository<HistoricalAppointment,Long> {
    List<HistoricalAppointment> getByUserId(Long id);
    List<HistoricalAppointment> getByEmployId(Long id);
}
