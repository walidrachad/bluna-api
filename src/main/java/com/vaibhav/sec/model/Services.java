package com.vaibhav.sec.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String price;
    private String dateStart;
    private String image;
    private String dateFinish;
    private String timeStart;
    private String timeFinish;
    private Boolean active;
    private String duration;
    private String timePreparation;
    private Boolean online;
    private Boolean paidOnline;
    private Long maxEmploy;
    private Long maxClient;
    private Boolean gift;
    private Boolean atHome;
    private Boolean deposit;
    private Long categoryId;
    private Long typeId;
    private Integer sessions;
    private Integer validity;
    private Long organizationId;

    public Services() {

    }

    public Services(Long id, String name, String description, String price, String dateStart, String image, String dateFinish, String timeStart, String timeFinish,
                    Boolean active, String duration, String timePreparation, Boolean online, Boolean paidOnline, Long maxEmploy, Long maxClient, Boolean gift,
                    Boolean atHome, Boolean deposit, Long categoryId, Long typeId, Integer sessions, Integer validity, Long organizationId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dateStart = dateStart;
        this.image = image;
        this.dateFinish = dateFinish;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.active = active;
        this.duration = duration;
        this.timePreparation = timePreparation;
        this.online = online;
        this.paidOnline = paidOnline;
        this.maxEmploy = maxEmploy;
        this.maxClient = maxClient;
        this.gift = gift;
        this.atHome = atHome;
        this.deposit = deposit;
        this.categoryId = categoryId;
        this.typeId = typeId;
        this.sessions=sessions;
        this.validity=validity;
        this.id=id;
        this.organizationId = organizationId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTimePreparation() {
        return timePreparation;
    }

    public void setTimePreparation(String timePreparation) {
        this.timePreparation = timePreparation;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getPaidOnline() {
        return paidOnline;
    }

    public void setPaidOnline(Boolean paidOnline) {
        this.paidOnline = paidOnline;
    }

    public Long getMaxEmploy() {
        return maxEmploy;
    }

    public void setMaxEmploy(Long maxEmploy) {
        this.maxEmploy = maxEmploy;
    }

    public Long getMaxClient() {
        return maxClient;
    }

    public void setMaxClient(Long maxClient) {
        this.maxClient = maxClient;
    }

    public Boolean getGift() {
        return gift;
    }

    public void setGift(Boolean gift) {
        this.gift = gift;
    }

    public Boolean getAtHome() {
        return atHome;
    }

    public void setAtHome(Boolean atHome) {
        this.atHome = atHome;
    }

    public Boolean getDeposit() {
        return deposit;
    }

    public void setDeposit(Boolean deposit) {
        this.deposit = deposit;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getSessions() {
        return sessions;
    }

    public void setSessions(Integer sessions) {
        this.sessions = sessions;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
