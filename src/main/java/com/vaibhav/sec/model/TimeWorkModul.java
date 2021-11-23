package com.vaibhav.sec.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "time_work_module")
public class TimeWorkModul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer day;
    private Integer start;
    private Integer end;
    private Integer dep;
    private Long availableId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "timeWork_available",
            joinColumns = @JoinColumn(name = "timeWork_id"),
            inverseJoinColumns = @JoinColumn(name = "available_id"))
    private Set<Available>  available= new HashSet<>();
    private Long organizationId;

    public TimeWorkModul() {}

    public TimeWorkModul(String name, Integer day, Integer start, Integer end, Integer dep, Long availableId, Set<Available> available, Long organizationId) {
        this.name = name;
        this.day = day;
        this.start = start;
        this.end = end;
        this.dep = dep;
        this.availableId = availableId;
        this.available = available;
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

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getDep() {
        return dep;
    }

    public void setDep(Integer dep) {
        this.dep = dep;
    }

    public Long getAvailableId() {
        return availableId;
    }

    public void setAvailableId(Long availableId) {
        this.availableId = availableId;
    }

    public Set<Available> getAvailable() {
        return available;
    }

    public void setAvailable(Set<Available> available) {
        this.available = available;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
