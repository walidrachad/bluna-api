package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> getByDate(String date);
    List<Tag> getByEmployId(Long id);
    List<Tag> getByEmployIdAndWeek(Long id,String week);
    List<Tag> getByWeek(String week);
}
