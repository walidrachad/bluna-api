package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.Room;
import com.vaibhav.sec.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getEntity( @PathVariable Long organizationId){
        return ResponseEntity.ok(roomRepository.findAll());
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Room room,@PathVariable Long organizationId){
        return ResponseEntity.ok(roomRepository.save(room));
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        roomRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
