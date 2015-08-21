package com.greenowl.tracker.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_ROUTE")
public class Route{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "device_id")
    @Size(min = 0, max = 220)
    private String deviceId;

    public Route() {
    }

    public Route(String deviceId, Set<Point> points) {
        this.deviceId = deviceId;
        this.points = points;
    }

    @OneToMany(mappedBy = "route", targetEntity = Point.class, fetch = FetchType.EAGER)
    private Set<Point> points = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
