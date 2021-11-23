package com.vaibhav.sec.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String ownerName;
    private String ownerLastname;
    private String createAt;
    private String codePostal;
    private String city;
    private String address;
    private String fix;
    private String phoneNumber;
    private String status;
    private String code;
    private Long nTv;
    private String tva;

    public Organization() {
    }

    public Organization(Long id, String ownerName, String ownerLastname, String createAt, String codePostal, String city, String address, String fix, String phoneNumber, String status, String code, Long nTv, String tva) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerLastname = ownerLastname;
        this.createAt = createAt;
        this.codePostal = codePostal;
        this.city = city;
        this.address = address;
        this.fix = fix;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.code = code;
        this.nTv = nTv;
        this.tva = tva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getnTv() {
        return nTv;
    }

    public void setnTv(Long nTv) {
        this.nTv = nTv;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }
}
