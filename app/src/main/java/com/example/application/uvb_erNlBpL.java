package com.example.application;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;


import java.util.Set;

/**
 * ukl_jsNfBqL.class
 *
 * BLE 스캔용 -> L 이상
 */


public class uvb_erNlBpL {

    public interface ScanListener{
        void onScanResult(ScanResult scanResult);
        void onPairedDevicesResult(Set<BluetoothDevice> pairedDevices);
    }

    private ScanCallback leScanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            if (scanListener != null){
                scanListener.onScanResult(result);
            }
        }

        @Override
        public void onScanFailed(int errorCode) {

        }
    };


    private Context context;
    private ScanListener scanListener;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;



    public uvb_erNlBpL(Context context, ScanListener scanListener) {
        this.context = context;
        this.scanListener = scanListener;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean isBluetoothOn(){
        if (bluetoothAdapter == null){
            return false;
        }

        return bluetoothAdapter.isEnabled();
    }

    public void scanPairedDevices(){
        if (bluetoothAdapter == null){
            return;
        }
        if (scanListener == null){
            return;
        }
        try{
            scanListener.onPairedDevicesResult(bluetoothAdapter.getBondedDevices());
        }catch (Exception e){}
    }

    /**
     * ACCESS_COARSE_LOCATION 권한체크 해야함
     */
    public void startLeScan(){
        if (bluetoothAdapter == null){
            return;
        }
        if (bluetoothLeScanner == null){
            return;
        }
        try{
            bluetoothLeScanner.startScan(leScanCallback);
        }catch (Exception e){}
    }

    public void stopLeScan(){
        try {
            bluetoothLeScanner.stopScan(leScanCallback);
        }catch (Exception e){}
    }


    /**
     * Eddystone Url Utils
     */
    // The Eddystone Service UUID
//    private static final ParcelUuid EDDYSTONE_SERVICE_UUID =
//            ParcelUuid.fromString("0000FEAA-0000-1000-8000-00805F9B34FB");
//
//    private final SparseArray<String> URI_SCHEMES = new SparseArray<String>() {{
//        put((byte) 0, "http://www.");
//        put((byte) 1, "https://www.");
//        put((byte) 2, "http://");
//        put((byte) 3, "https://");
//        put((byte) 4, "urn:uuid:");
//    }};
//
//    private final SparseArray<String> URL_CODES = new SparseArray<String>() {{
//        put((byte) 0, ".com/");
//        put((byte) 1, ".org/");
//        put((byte) 2, ".edu/");
//        put((byte) 3, ".net/");
//        put((byte) 4, ".info/");
//        put((byte) 5, ".biz/");
//        put((byte) 6, ".gov/");
//        put((byte) 7, ".com");
//        put((byte) 8, ".org");
//        put((byte) 9, ".edu");
//        put((byte) 10, ".net");
//        put((byte) 11, ".info");
//        put((byte) 12, ".biz");
//        put((byte) 13, ".gov");
//    }};
//
//    private String decodeUrl(byte[] serviceData) {
//        StringBuilder url = new StringBuilder();
//        int offset = 2;
//        byte b = serviceData[offset++];
//        String scheme = URI_SCHEMES.get(b);
//        if (scheme != null) {
//            url.append(scheme);
//            if (URLUtil.isNetworkUrl(scheme)) {
//                return decodeUrl(serviceData, offset, url);
//            } else if ("urn:uuid:".equals(scheme)) {
//                return decodeUrnUuid(serviceData, offset, url);
//            }
//        }
//        return url.toString();
//    }
//
//    private String decodeUrl(byte[] serviceData, int offset, StringBuilder urlBuilder) {
//        while (offset < serviceData.length) {
//            byte b = serviceData[offset++];
//            String code = URL_CODES.get(b);
//            if (code != null) {
//                urlBuilder.append(code);
//            } else {
//                urlBuilder.append((char) b);
//            }
//        }
//        return urlBuilder.toString();
//    }
//
//    private String decodeUrnUuid(byte[] serviceData, int offset, StringBuilder urnBuilder) {
//        ByteBuffer bb = ByteBuffer.wrap(serviceData);
//        // UUIDs are ordered as byte array, which means most significant first
//        bb.order(ByteOrder.BIG_ENDIAN);
//        long mostSignificantBytes, leastSignificantBytes;
//        try {
//            bb.position(offset);
//            mostSignificantBytes = bb.getLong();
//            leastSignificantBytes = bb.getLong();
//        } catch (BufferUnderflowException e) {
//            return null;
//        }
//        UUID uuid = new UUID(mostSignificantBytes, leastSignificantBytes);
//        urnBuilder.append(uuid.toString());
//        return urnBuilder.toString();
//    }
}
