package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.Role;

public class UserResponse {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String token;
    private Object user;
    private Long organizationId;
    private Role role;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String username, String email, String token, Object role, Long organizationId, Role role1) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.token = token;
        this.user = role;
        this.organizationId = organizationId;
        this.role = role1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
