package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long permissionId;
    private String createAt;
    private String updateAt;
    private Long organizationId;

    public RolePermission() {}
    public RolePermission(Long id, Long permissionId, String createAt, String updateAt, Long organizationId) {
        this.id = id;
        this.permissionId = permissionId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.organizationId = organizationId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
