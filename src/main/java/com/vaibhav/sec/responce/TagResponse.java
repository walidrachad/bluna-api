package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.Employ;

public class TagResponse {
    private Long id;
    private String title;
    private Employ employ;
    private String description;
    private Integer status;
    private Boolean active;
    private String date;

    public TagResponse() {
    }

    public TagResponse(Long id, String title, Employ employ, String description, Integer status, Boolean active, String date) {
        this.id = id;
        this.title = title;
        this.employ = employ;
        this.description = description;
        this.status = status;
        this.active = active;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employ getEmploy() {
        return employ;
    }

    public void setEmploy(Employ employ) {
        this.employ = employ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
