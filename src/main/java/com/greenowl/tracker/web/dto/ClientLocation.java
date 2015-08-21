package com.greenowl.tracker.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientLocation {

    private Double lat;
    private Double lon;
    private Double speed;
    private Float accuracy;
    private Float bearing;
    private Double altitude;
    private Long time;
    private String deviceCalc;

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDeviceCalc() {
        return deviceCalc;
    }

    public void setDeviceCalc(String deviceCalc) {
        this.deviceCalc = deviceCalc;
    }

    @Override
    public String toString() {
        return "ClientLocation{" +
                "time=" + time +
                ", altitude=" + altitude +
                ", bearing=" + bearing +
                ", accuracy=" + accuracy +
                ", speed=" + speed +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
