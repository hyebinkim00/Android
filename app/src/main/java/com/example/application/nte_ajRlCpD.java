package com.example.application;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * npt_hnRfCqD.class
 */
public class nte_ajRlCpD {

//    @SerializedName("location")
//    public nte_ajRlLpI ntaRLI;
//    @SerializedName("app")
//    public List<nte_ajRlApI> ntRAIList;
//    @SerializedName("wifi")
//    public List<nte_ajRlWpI> ntaRWIList;
//    @SerializedName("ble")
//    public List<nte_ajRlBpI> ntaRBIList;
//    @SerializedName("log")
//    public List<nte_ajRlLp> ntaRLList;
//    @SerializedName("timestamp")
//    public long timestamp;
//    @SerializedName("timezone")
//    public String timezone;
//    @SerializedName("network_time")
//    public char network_time;
//    @SerializedName("time_gap")
//    public long time_gap;
//    @SerializedName("app_timeline")
//    public String app_timeline;
    @SerializedName("push")
    public String push;

    public nte_ajRlCpD(String push) {
        this.push = push;

    }


    public void setPush(String push) {
        this.push = push;
    }
}
