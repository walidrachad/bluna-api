package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.Employ;
import com.vaibhav.sec.model.Permission;

public class PermissionResponse {
    private Long id;
    private String createAt;
    private String updateAt;
    private Employ employ;
    private Permission permission;

    public PermissionResponse() {}

    public PermissionResponse(Long id, String createAt, String updateAt, Employ employ, Permission permission) {
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.employ = employ;
        this.permission = permission;
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

    public Employ getEmployId() {
        return employ;
    }

    public void setEmployId(Employ employ) {
        this.employ = employ;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
