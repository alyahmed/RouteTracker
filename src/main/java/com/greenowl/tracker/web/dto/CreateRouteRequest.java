package com.greenowl.tracker.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateRouteRequest {

    private String deviceId;

    @JsonProperty("driveLocations")
    private List<ClientLocation> locations;

    private String platform; // ANDROID or IPHONE

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<ClientLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<ClientLocation> locations) {
        this.locations = locations;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "CreateRouteRequest{" +
                "deviceId='" + deviceId + '\'' +
                ", locations=" + locations +
                '}';
    }
}
