package com.vaibhav.sec.controller;

import com.vaibhav.sec.repo.EmployRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vaibhav.sec.repo.TagRepository;
import com.vaibhav.sec.responce.TagResponse;
import java.util.ArrayList;
import com.vaibhav.sec.model.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    @Autowired
    TagRepository tagRepository;
    @Autowired
    EmployRepository employRepository;
    @GetMapping(value = "/getByDate/{date}/{organizationId}")
    public ResponseEntity<?> getEntityByDate(@PathVariable String date,@PathVariable Long organizationId){
        List<TagResponse> tagResponse = new ArrayList<>();
        tagRepository.getByDate(date).forEach(dat->{
            TagResponse  response = new TagResponse();
            response.setDate(dat.getDate());
            response.setId(dat.getId());
            response.setActive(dat.getActive());
            response.setDescription(dat.getDescription());
            response.setStatus(dat.getStatus());
            response.setTitle(dat.getTitle());
            response.setEmploy(employRepository.findById(dat.getEmployId()).get());
            tagResponse.add(response);
        });
        return  ResponseEntity.ok(tagResponse);
    }

    @GetMapping(value = "/getByEmploy/{id}/{organizationId}")
    public ResponseEntity<?> getEntityByEmploy(@PathVariable Long id,@PathVariable Long organizationId){
        return  ResponseEntity.ok(tagRepository.getByEmployId(id));
    }

    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Tag tag,@PathVariable Long organizationId){
        return ResponseEntity.ok(tagRepository.save(tag));
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        tagRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
    @GetMapping(value = "/getByEmployIdAndWeek/{id}/{week}/{organizationId}")
    public ResponseEntity<?> getByEmployIdAndWeek(@PathVariable Long id,@PathVariable String week,@PathVariable Long organizationId){
        List<TagResponse> tagResponse = new ArrayList<>();
        tagRepository.getByEmployIdAndWeek(id,week).forEach(dat->{
            TagResponse  response = new TagResponse();
            response.setDate(dat.getDate());
            response.setId(dat.getId());
            response.setActive(dat.getActive());
            response.setDescription(dat.getDescription());
            response.setStatus(dat.getStatus());
            response.setTitle(dat.getTitle());
            response.setEmploy(employRepository.findById(dat.getEmployId()).get());
            tagResponse.add(response);
        });
        return  ResponseEntity.ok(tagResponse);
    }
    @GetMapping(value = "/getByWeek/{week}/{organizationId}")
    public ResponseEntity<?> getEntityBy(@PathVariable String week,@PathVariable Long organizationId){
        List<TagResponse> tagResponse = new ArrayList<>();
        tagRepository.getByWeek(week).forEach(dat->{
            TagResponse  response = new TagResponse();
            response.setDate(dat.getDate());
            response.setId(dat.getId());
            response.setActive(dat.getActive());
            response.setDescription(dat.getDescription());
            response.setStatus(dat.getStatus());
            response.setTitle(dat.getTitle());
            response.setEmploy(employRepository.findById(dat.getEmployId()).get());
            tagResponse.add(response);
        });
        return  ResponseEntity.ok(tagResponse);
    }
}




