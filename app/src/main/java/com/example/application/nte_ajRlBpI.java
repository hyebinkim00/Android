package com.example.application;


import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Build;


import com.google.gson.annotations.SerializedName;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.UUID;

/**
 * npt_hnRfBqI.class
 */
public class nte_ajRlBpI {

    @SerializedName("bssid")
    private String bssid = "";
    @SerializedName("ssid")
    private String ssid = "";
    @SerializedName("group")
    private int group = -1;
    @SerializedName("group_detail")
    private int groupDetail = -1;
    @SerializedName("manufacturer")
    private int manufacturer = -1;
    @SerializedName("rssi")
    private int rssi = -1;
    @SerializedName("pairing")
    private String pairing = "N";

    // iBeacon 정보전달
    @SerializedName("uuid")
    private String uuid = "";
    @SerializedName("major")
    private int major = -1;
    @SerializedName("minor")
    private int minor = -1;


    public nte_ajRlBpI(ScanResult scanResult){
        try {
            BluetoothDevice device = scanResult.getDevice();
            if (device.getAddress() != null){
                this.bssid = device.getAddress();
            }
            if (device.getName() != null){
                this.ssid = device.getName();
            }
            if (device.getBluetoothClass() != null){
                this.group = device.getBluetoothClass().getMajorDeviceClass();
                this.groupDetail = device.getBluetoothClass().getDeviceClass();
            }
            this.rssi = scanResult.getRssi();
            if (scanResult.getScanRecord() == null){
                return;
            }

            byte[] scanRecord = scanResult.getScanRecord().getBytes();
            if (scanRecord[7] == 0x02 && scanRecord[8] == 0x15) { // iBeacon indicator
                this.uuid = getGuidFromByteArray(Arrays.copyOfRange(scanRecord, 9, 25)).toString();
                this.major = (scanRecord[25] & 0xff) * 0x100 + (scanRecord[26] & 0xff);
                this.minor = (scanRecord[27] & 0xff) * 0x100 + (scanRecord[28] & 0xff);
            }

            if (scanResult.getScanRecord().getManufacturerSpecificData() != null){
                this.manufacturer = scanResult.getScanRecord().getManufacturerSpecificData().keyAt(0);
            }
        }catch (Exception e){}
    }


    public void update(ScanResult scanResult){
        try {
            BluetoothDevice device = scanResult.getDevice();
            if (device.getAddress() != null){
                this.bssid = device.getAddress();
            }
            if (device.getName() != null){
                this.ssid = device.getName();
            }
            if (device.getBluetoothClass() != null){
                this.group = device.getBluetoothClass().getMajorDeviceClass();
                this.groupDetail = device.getBluetoothClass().getDeviceClass();
            }
            this.rssi = scanResult.getRssi();
            if (scanResult.getScanRecord() == null){
                return;
            }
            if (scanResult.getScanRecord().getManufacturerSpecificData() != null){
                this.manufacturer = scanResult.getScanRecord().getManufacturerSpecificData().keyAt(0);
            }
        }catch (Exception e){}
    }

    public nte_ajRlBpI(BluetoothDevice device) {
        try {
            if (device.getAddress() != null){
                this.bssid = device.getAddress();
            }
            if (device.getName() != null){
                this.ssid = device.getName();
            }
            if (device.getBluetoothClass() != null){
                this.group = device.getBluetoothClass().getMajorDeviceClass();
                this.groupDetail = device.getBluetoothClass().getDeviceClass();
            }
        }catch (Exception e){}
    }

    public void update(BluetoothDevice device) {
        try {
            if (device.getAddress() != null){
                this.bssid = device.getAddress();
            }
            if (device.getName() != null){
                this.ssid = device.getName();
            }
            if (device.getBluetoothClass() != null){
                this.group = device.getBluetoothClass().getMajorDeviceClass();
                this.groupDetail = device.getBluetoothClass().getDeviceClass();
            }
            this.pairing = "Y";
        }catch (Exception e){}
    }

    public UUID getGuidFromByteArray(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        UUID uuid = new UUID(bb.getLong(), bb.getLong());
        return uuid;
    }
}
