package com.vaibhav.sec.responce;

import java.util.List;

public class ServiceRequest {
    private Long id;
    private String name;
    private String description;
    private String price;
    private String dateStart;
    private String image;
    private String dateFinish;
    private String timeStart;
    private String timeFinish;
    private String active;
    private String duration;
    private String timePreparation;
    private String isOnline;
    private String isPaidOnline;
    private Long maxEmploy;
    private Long maxClient;
    private String isGift;
    private String atHome;
    private String deposit;
    private Long categoryId;
    private List<Long> employs;
    private List<Long> rooms;
    private Long typeId;
    private Integer sessions;
    private Integer validity;
    public ServiceRequest() {
    }

    public ServiceRequest(Long id, String name, String description, String price, String dateStart, String image, String dateFinish,
                          String timeStart, String timeFinish, String active, String duration,
                          String timePreparation, String isOnline, String isPaidOnline, Long maxEmploy,
                          Long maxClient, String isGift, String atHome, String deposit, Long categoryId,
                          List<Long> employs, List<Long> rooms, Long typeId,Integer sessions,Integer validity) {
        this.id = id;
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
        this.isOnline = isOnline;
        this.isPaidOnline = isPaidOnline;
        this.maxEmploy = maxEmploy;
        this.maxClient = maxClient;
        this.isGift = isGift;
        this.atHome = atHome;
        this.deposit = deposit;
        this.categoryId = categoryId;
        this.employs = employs;
        this.rooms = rooms;
        this.typeId = typeId;
        this.sessions =sessions;
        this.validity=validity;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
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

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getIsPaidOnline() {
        return isPaidOnline;
    }

    public void setIsPaidOnline(String isPaidOnline) {
        this.isPaidOnline = isPaidOnline;
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

    public String getIsGift() {
        return isGift;
    }

    public void setIsGift(String isGift) {
        this.isGift = isGift;
    }

    public String getAtHome() {
        return atHome;
    }

    public void setAtHome(String atHome) {
        this.atHome = atHome;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Long> getEmploys() {
        return employs;
    }

    public void setEmploys(List<Long> employs) {
        this.employs = employs;
    }

    public List<Long> getRooms() {
        return rooms;
    }

    public void setRooms(List<Long> rooms) {
        this.rooms = rooms;
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
}
