package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "times")
public class Times {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long timeWorkId;
    private Long employId;
    private String label;
    private Long organizationId;

    public Times() {
    }

    public Times(Long id, Long timeWorkId, Long employId, String label, Long organizationId) {
        this.id = id;
        this.timeWorkId = timeWorkId;
        this.employId = employId;
        this.label = label;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeWorkId() {
        return timeWorkId;
    }

    public void setTimeWorkId(Long timeWorkId) {
        this.timeWorkId = timeWorkId;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
