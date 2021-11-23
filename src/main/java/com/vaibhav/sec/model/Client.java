package com.vaibhav.sec.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private String image;
    private String gender;
    private String fix;
    private String dateOfbrith;
    private String codePostal;
    private String city;
    private Boolean sendPubMail;
    private Boolean sendPubSms;
    private Boolean remamberSms;
    private Boolean tikeAppointment;
    private Boolean payAppointment;
    private Boolean isLogin;
    private String password;
    private Long roleId;
    private String roleName;
    private Long userId;
    private String latitude;
    private String longitude;
    private String age;
    private Long organizationId;
    public Client() {}
    public Client(String firstname, String lastname, String address, String email, String phone, String image, String gender, String fix, String dateOfbrith, String codePostal, String city, Boolean sendPubMail, Boolean sendPubSms, Boolean remamberSms, Boolean tikeAppointment, Boolean payAppointment, Boolean isLogin, String password, Long roleId, String roleName, Long userId, String latitude, String longitude, String age, Long organizationId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.gender = gender;
        this.fix = fix;
        this.dateOfbrith = dateOfbrith;
        this.codePostal = codePostal;
        this.city = city;
        this.sendPubMail = sendPubMail;
        this.sendPubSms = sendPubSms;
        this.remamberSms = remamberSms;
        this.tikeAppointment = tikeAppointment;
        this.payAppointment = payAppointment;
        this.isLogin = isLogin;
        this.password = password;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.age=age;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getDateOfbrith() {
        return dateOfbrith;
    }

    public void setDateOfbrith(String dateOfbrith) {
        this.dateOfbrith = dateOfbrith;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getSendPubMail() {
        return sendPubMail;
    }

    public void setSendPubMail(Boolean sendPubMail) {
        this.sendPubMail = sendPubMail;
    }

    public Boolean getSendPubSms() {
        return sendPubSms;
    }

    public void setSendPubSms(Boolean sendPubSms) {
        this.sendPubSms = sendPubSms;
    }

    public Boolean getRemamberSms() {
        return remamberSms;
    }

    public void setRemamberSms(Boolean remamberSms) {
        this.remamberSms = remamberSms;
    }

    public Boolean getTikeAppointment() {
        return tikeAppointment;
    }

    public void setTikeAppointment(Boolean tikeAppointment) {
        this.tikeAppointment = tikeAppointment;
    }

    public Boolean getPayAppointment() {
        return payAppointment;
    }

    public void setPayAppointment(Boolean payAppointment) {
        this.payAppointment = payAppointment;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
