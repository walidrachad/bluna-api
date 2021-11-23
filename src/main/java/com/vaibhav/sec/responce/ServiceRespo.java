package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.Employ;
import com.vaibhav.sec.model.Room;
import com.vaibhav.sec.model.Services;

import java.util.List;
import java.util.Set;

public class ServiceRespo {
    private Long id;
    private String name;
    private String description;
    private String price;
    private String dateStart;
    private String image;
    private String dateFinish;
    private String timeStart;
    private String timeFinish;
    private boolean active;
    private String duration;
    private String timePreparation;
    private boolean online;
    private boolean paidOnline;
    private Long maxEmploy;
    private Long maxClient;
    private boolean gift;
    private boolean atHome;
    private boolean deposit;
    private Long categoryId;
    private Set<Employ> employs;
    private Set<Room> rooms;
    private Long typeId;
    private Integer services;
    private Integer validity;
    private List<Services> serviceList;
    public ServiceRespo() {
    }

    public ServiceRespo(Long id, String name, String description, String price, String dateStart, String image, String dateFinish, String timeStart,
                        String timeFinish, boolean active, String duration, String timePreparation, boolean online, boolean paidOnline,
                        Long maxEmploy, Long maxClient, boolean gift, boolean atHome, boolean deposit,
                        Long categoryId, Set<Employ> employs, Set<Room> rooms,
                        Long typeId,Integer services,Integer validity,List<Services> serviceList) {
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
        this.online = online;
        this.paidOnline = paidOnline;
        this.maxEmploy = maxEmploy;
        this.maxClient = maxClient;
        this.gift = gift;
        this.atHome = atHome;
        this.deposit = deposit;
        this.categoryId = categoryId;
        this.employs = employs;
        this.rooms =rooms;
        this.typeId = typeId;
        this.services=services;
        this.validity=validity;
        this.serviceList=serviceList;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
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

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isPaidOnline() {
        return paidOnline;
    }

    public void setPaidOnline(boolean paidOnline) {
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

    public boolean isGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public boolean isAtHome() {
        return atHome;
    }

    public void setAtHome(boolean atHome) {
        this.atHome = atHome;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Set<Employ> getEmploys() {
        return employs;
    }

    public void setEmploys(Set<Employ> employs) {
        this.employs = employs;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getServices() {
        return services;
    }

    public void setServices(Integer services) {
        this.services = services;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public List<Services> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Services> serviceList) {
        this.serviceList = serviceList;
    }
}
