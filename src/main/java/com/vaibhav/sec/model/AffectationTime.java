package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "affectation_time")
public class AffectationTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employId;
    private Long timeWorkId;
    private Long organizationId;

    public AffectationTime() {
    }

    public AffectationTime(Long id, Long employId, Long timeWorkId,Long organizationId) {
        this.id = id;
        this.employId = employId;
        this.timeWorkId = timeWorkId;
        this.organizationId=organizationId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
