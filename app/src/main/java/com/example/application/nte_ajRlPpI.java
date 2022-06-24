package com.example.application;

import com.google.gson.annotations.SerializedName;

public class nte_ajRlPpI {

    @SerializedName("package")
    private String package_name;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("timestamp")
    private long timestamp;

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getGeo_timestamp() {
        return geo_timestamp;
    }

    public void setGeo_timestamp(long geo_timestamp) {
        this.geo_timestamp = geo_timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @SerializedName("geo_timestamp")
    private long geo_timestamp;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    public nte_ajRlPpI(String package_name, String title, String content, long timestamp) {
        this.package_name = package_name;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.geo_timestamp = 0L;
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public void setGeoTimeStamp(long geo_timestamp) {
        this.geo_timestamp = geo_timestamp;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
