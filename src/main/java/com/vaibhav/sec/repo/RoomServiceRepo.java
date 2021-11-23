package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.RoomService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomServiceRepo extends JpaRepository<RoomService,Long> {
    List<RoomService> getByServiceId(Long id);
    List<RoomService> getByRoomId(Long id);
}
