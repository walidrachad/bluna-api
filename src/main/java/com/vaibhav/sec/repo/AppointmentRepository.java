package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> getByClientId(Long id);
    List<Appointment> getByServiceId(Long id);
    List<Appointment> getByWeek(String week);
    List<Appointment> getByWeekAndEmployId(String week,Long employId);

}
