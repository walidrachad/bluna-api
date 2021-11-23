package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "time_module_employ")
public class TimeModuleEmploy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employId;
    private Long timeWorkModuleId;
    private Long organizationId;

    public TimeModuleEmploy() {}

    public TimeModuleEmploy(Long employId, Long timeWorkModuleId, Long organizationId) {
        this.organizationId = organizationId;
        this.id = id;
        this.employId = employId;
        this.timeWorkModuleId = timeWorkModuleId;
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

    public Long getTimeWorkModuleId() {
        return timeWorkModuleId;
    }

    public void setTimeWorkModuleId(Long timeWorkModuleId) {
        this.timeWorkModuleId = timeWorkModuleId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
