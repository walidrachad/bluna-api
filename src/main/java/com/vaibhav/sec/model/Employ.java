package com.vaibhav.sec.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employ")
public class Employ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roleId;
    private String roleName;
    private String password;
    private Long userId;
    private Long organisationId;
    private String firstname;
    private String address;
    private String email;
    private String lastname;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String phone;
    private String image;
    private String gender;
    private String dateOfBirth;
    private boolean status;
    @CreatedDate
    private String createAt;
    @LastModifiedDate
    private String updateAt;
    private Long organizationId;

    public Employ() {}
    public Employ(Long id, String password, Long roleId, String roleName, Long userId, Long organisationId, String firstname, String address, String email, String lastname, String phone, String image, String gender, String dateOfBirth, boolean status, String createAt, String updateAt, Long organizationId) {
        this.id = id;
        this.password=password;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userId = userId;
        this.organisationId = organisationId;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.lastname = lastname;
        this.phone = phone;
        this.image = image;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
