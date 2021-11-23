package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Room getById(Long id);
}
