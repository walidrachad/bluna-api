package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.Weeks;

import java.util.List;

public class TimeWorkResponse {
    private Long id;
    private String week;
    private String date;
    private String day;
    private Weeks weeks;
    private List<TimesResponse> times;

    public TimeWorkResponse() {
    }

    public TimeWorkResponse(String week, String date, String day, Weeks weeks, List<TimesResponse> times) {
        this.week = week;
        this.date = date;
        this.day = day;
        this.weeks = weeks;
        this.times = times;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<TimesResponse> getTimes() {
        return times;
    }

    public void setTimes(List<TimesResponse> times) {
        this.times = times;
    }

    public Weeks getWeeks() {
        return weeks;
    }

    public void setWeeks(Weeks weeks) {
        this.weeks = weeks;
    }
}
