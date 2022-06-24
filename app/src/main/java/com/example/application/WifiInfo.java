package com.example.application;

import android.content.Context;
import android.net.wifi.WifiManager;

public class WifiInfo {

    private Context context;
    private WifiManager wifiManager;
//    WifiInfo wifiManager = (WifiInfo)context.getSystemService(Context.WIFI_SERVICE);


    public void wifiClass(Context context){
        this.context = context;
        wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
    }





}
