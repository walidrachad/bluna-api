package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private Integer maxClient;
    private Integer maxEmploy;
    private Boolean isOpen;
    private Boolean haveTime;
    private String start;
    private String end;
    private boolean organisationTime;
    private Long organizationId;


    public Room() {}

    public Room(String label, Integer maxClient, Integer maxEmploy, Boolean isOpen, Boolean haveTime, String start, String end, boolean organisationTime, Long organizationId) {
        this.label = label;
        this.maxClient = maxClient;
        this.maxEmploy = maxEmploy;
        this.isOpen = isOpen;
        this.haveTime = haveTime;
        this.start = start;
        this.end = end;
        this.organisationTime = organisationTime;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getMaxClient() {
        return maxClient;
    }

    public void setMaxClient(Integer maxClient) {
        this.maxClient = maxClient;
    }

    public Integer getMaxEmploy() {
        return maxEmploy;
    }

    public void setMaxEmploy(Integer maxEmploy) {
        this.maxEmploy = maxEmploy;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getHaveTime() {
        return haveTime;
    }

    public void setHaveTime(Boolean haveTime) {
        this.haveTime = haveTime;
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

    public boolean isOrganisationTime() {
        return organisationTime;
    }

    public void setOrganisationTime(boolean organisationTime) {
        this.organisationTime = organisationTime;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
