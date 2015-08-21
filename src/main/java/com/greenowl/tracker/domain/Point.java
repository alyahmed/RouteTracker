package com.greenowl.tracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_CLIENT_POINT")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "latitude")
    private Double lat; // Stored as a double, will lose some precision

    @Column(name = "longitude")
    private Double lon; // Stored as a double, will lose some precision

    private Double speed;

    private Float accuracy;

    private Float bearing;

    private Double altitude;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_route_id", referencedColumnName = "id", nullable = false)
    private Route route;

    public Point() {
    }

    public Point(Double lat, Double lon, Double speed, Float accuracy, Float bearing, Double altitude) {
        this.lat = lat;
        this.lon = lon;
        this.speed = speed;
        this.accuracy = accuracy;
        this.bearing = bearing;
        this.altitude = altitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Float accuracy) {
        this.accuracy = accuracy;
    }

    public Float getBearing() {
        return bearing;
    }

    public void setBearing(Float bearing) {
        this.bearing = bearing;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "ClientPoint{" +
                "id=" + id +
                ", lat=" + lat +
                ", lon=" + lon +
                ", speed=" + speed +
                ", accuracy=" + accuracy +
                ", bearing=" + bearing +
                ", altitude=" + altitude +
                ", route=" + route +
                '}';
    }


}
