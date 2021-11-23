package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name="time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long timesId;
    private String start;
    private String end;
    private Integer duration;
    private Long organizationId;

    public Time() {
    }

    public Time(Long id, Long timesId, String start, String end, Integer duration, Long organizationId) {
        this.id = id;
        this.timesId = timesId;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimesId() {
        return timesId;
    }

    public void setTimesId(Long timesId) {
        this.timesId = timesId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
