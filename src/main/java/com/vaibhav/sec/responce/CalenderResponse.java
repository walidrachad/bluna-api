package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.TimeWork;
import com.vaibhav.sec.model.TimeWorkModul;

import java.util.List;

public class CalenderResponse {
    private Long id;
    private String name;
    private Integer day;
    private Integer start;
    private Integer end;
    private Integer dep;
    private Long availableId;
    private List<TimeWork> timeWork;

    public CalenderResponse() {
    }

    public CalenderResponse(Long id, String name, Integer day, Integer start, Integer end, Integer dep, Long availableId, List<TimeWork> timeWork) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.start = start;
        this.end = end;
        this.dep = dep;
        this.availableId = availableId;
        this.timeWork = timeWork;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getDep() {
        return dep;
    }

    public void setDep(Integer dep) {
        this.dep = dep;
    }

    public Long getAvailableId() {
        return availableId;
    }

    public void setAvailableId(Long availableId) {
        this.availableId = availableId;
    }

    public List<TimeWork> getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(List<TimeWork> timeWork) {
        this.timeWork = timeWork;
    }
}
