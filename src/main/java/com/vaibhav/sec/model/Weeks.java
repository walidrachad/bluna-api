package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "weeks")
public class Weeks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String start;
    private String end;
    private String week;
    public Weeks() {}
    public Weeks(Long id, String start, String end, String week) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.week = week;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
