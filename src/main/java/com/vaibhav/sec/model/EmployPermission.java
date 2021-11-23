package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "employ_permission")
public class EmployPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long permissionId;
    private String createAt;
    private String updateAt;
    private Long employId;
    private Long organizationId;

    public EmployPermission() {}

    public EmployPermission(Long permissionId, String createAt, String updateAt, Long employId, Long organizationId) {
        this.permissionId = permissionId;
        this.organizationId = organizationId;
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.employId = employId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
