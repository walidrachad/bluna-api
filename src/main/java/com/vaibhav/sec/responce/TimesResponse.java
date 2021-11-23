package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.Time;

import java.util.List;

public class TimesResponse {
    private Long id;
    private Long employId;
    private String label;
    private List<Time> time;
    private Long index;

    public TimesResponse() {
    }

    public TimesResponse(Long id, Long employId, String label, List<Time> time, Long index) {
        this.id = id;
        this.employId = employId;
        this.label = label;
        this.time = time;
        this.index = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }
}
