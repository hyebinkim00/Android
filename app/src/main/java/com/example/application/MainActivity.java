package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.ui.NavigationUiSaveStateControl;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , uvb_erNlBpL.ScanListener, View.OnClickListener{


    // Channel에 대한 id 생성 : Channel을 구부하기 위한 ID 이다.
    private static final String CHANNEL_ID = "NOTI_CHANNEL2";
    // Channel을 생성 및 전달해 줄 수 있는 Manager 생성
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder builder;
    private NotificationCompat.Builder builder2;

    private Set<BluetoothDevice> pairedDevicess;
    private HashMap<String, nte_ajRlBpI> bluetoothInfoMap;
    private Map<String, String> mMap;

    private uvb_erNlBpL LE;
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    BottomNavigationView bottomNavigationView;
    NavHost navHost;
    Button button;
    Button button2;
    ImageView imageView;

    RemoteViews remoteViews2;

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    nte_ajRlPpI push = null;

    nte_ajRlCpDS ntaRCDS ;
    String dd;
    // Notivication에 대한 ID 생성
    private static final int NOTIFICATION_ID = 0;
    private static final int NOTIFICATION_ID1 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 생성 버튼
        button = findViewById(R.id.btn1);
        button.setOnClickListener(this);
        // 취소 버튼
        button2 = findViewById(R.id.btn2);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        toolbar = findViewById(R.id.toolbarlay);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navigationView = findViewById(R.id.naView);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView  = findViewById(R.id.bottom_nav);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host);
        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.getNavController());

//        열고 닫는 레이아웃
        drawerLayout = findViewById(R.id.drawLay);


        ntaRCDS = new nte_ajRlCpDS(new ArrayList<nte_ajRlCpD>());


        ntaRCDS.ntRCDSList.add(new nte_ajRlCpD("") );

        ntaRCDS.ntRCDSList.get(0).setPush(dd);


        imageView = findViewById(R.id.toolbar_menu_img);



//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//            }
//        },60000);


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("1","val1");
        Log.d("hb",jsonObject.toString());

        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonObject);




        //notification manager 생성
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // 기기(device)의 SDK 버전 확인 ( SDK 26 버전 이상인지 - VERSION_CODES.O = 26)
        if(android.os.Build.VERSION.SDK_INT
                >= android.os.Build.VERSION_CODES.O){
            //Channel 정의 생성자( construct 이용 )
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,"Test Notification",NotificationManager.IMPORTANCE_HIGH);
            //Channel에 대한 기본 설정

//            notificationChannel.enableLights(true);
            notificationChannel.getLockscreenVisibility();
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{0L});
            notificationChannel.setDescription("Notification from Mascot");
            // Manager을 이용하여 Channel 생성
            mNotificationManager.createNotificationChannel(notificationChannel);

        }


        RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(),R.layout.remoteview);
        remoteViews2 = new RemoteViews(getApplicationContext().getPackageName(),R.layout.remoteview2);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img);

        Intent intent = new Intent(this,MainActivity2.class);


        Intent intent1 = new Intent(this,MainActivity2.class);
        intent1.setAction(Intent.ACTION_SCREEN_ON);

        PendingIntent snoozePendingIntent  = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        PendingIntent pendingIntent2 = PendingIntent.getActivity(this,0,new Intent(),PendingIntent.FLAG_IMMUTABLE);


        builder = new NotificationCompat.Builder(this,CHANNEL_ID)
//                .setCustomContentView(remoteViews)
                .setContentTitle("builder1")
                .setContentText("text3")
//                .addAction(R.drawable.ic_baseline_settings_24,getString(R.string.app_name),snoozePendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle());


        messageModel[] messages = new messageModel[2];

        messages[0] = new messageModel("text1","sender1",String.valueOf(System.currentTimeMillis()));
        messages[1] = new messageModel("text2","sender2",String.valueOf(System.currentTimeMillis()));

        NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message(messages[0].getText(),System.currentTimeMillis(),messages[0].getSender());
        NotificationCompat.MessagingStyle.Message message2 = new NotificationCompat.MessagingStyle.Message(messages[1].getText(),System.currentTimeMillis(),messages[1].getSender());

        builder2 = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(new NotificationCompat.MessagingStyle(getResources().getString(R.string.app_name)).addMessage(message).addMessage(message2));

//        .setStyle(new NotificationCompat.BigTextStyle().bigText("BIG TEXT"));






        LE = new uvb_erNlBpL(this,MainActivity.this);

        if (LE.isBluetoothOn()) {

            LE.scanPairedDevices();
        }

        Blue();
//
//        PackageManager packageManager = this.getPackageManager();
//        Intent quIntent  = new Intent("");
//        List<ResolveInfo> resolveInfos = packageManager.queryBroadcastReceivers(intent,0);
//        ContentResolver contentResolver = app

    }

    public static String compress(String data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return Base64.encodeToString(compressed, Base64.DEFAULT);
    }


    //블루투스 스캔 콜백
    @Override
    public void onScanResult(final android.bluetooth.le.ScanResult scanResult) {


                try{

                    if (scanResult.getDevice() == null || scanResult.getDevice().getAddress() == null){
                        return;
                    }
                    if (bluetoothInfoMap == null){
                        bluetoothInfoMap = new HashMap<>();
                    }

                    if (bluetoothInfoMap.get(scanResult.getDevice().getAddress()) == null){
                        bluetoothInfoMap.put(scanResult.getDevice().getAddress(), new nte_ajRlBpI(scanResult));
                    }else{
                        bluetoothInfoMap.get(scanResult.getDevice().getAddress()).update(scanResult);

                    }

                }catch (Exception e){}

    }

    //블루투스 페어링 콜백
    @Override
    public void onPairedDevicesResult(final Set<BluetoothDevice> pairedDevices) {
        this.pairedDevicess = pairedDevices;
        Log.d("BL","TT"+pairedDevices.size());
        for (BluetoothDevice device : pairedDevicess){
            Log.d("BL",device.getName());
        }

        }

//
//        mMap = gson.fromJson(getString(R.string.sido_map), new TypeToken<Map<String, String>>() {}.getType());
//        Log.d("map",mMap.get("경기도"));
//        push = new nte_ajRlPpI(dd+" ","\0","c1",System.currentTimeMillis());
//        push.setLatitude(-11);
//        push.setLongitude(11);
//        push.setGeoTimeStamp(System.currentTimeMillis());
//
//
//        ArrayList<nte_ajRlPpI> notiList = new ArrayList<nte_ajRlPpI>();
//        notiList.add(push);
//
//        Log.d("list",notiList.get(0).getPackage_name());
//
//
//        String ss = gson.toJson(notiList);
//
//
//        String last = "111/222";
//
//        double lat = Double.parseDouble(last.split("/")[0]);
//        double lat2 = Double.parseDouble(last.split("/")[1]);
//
//        Log.d("T",String.valueOf(lat+"??"+lat2));
//
//
//
//        List<nte_ajRlPpI> pushInfoList = gson.fromJson(ss, new TypeToken<List<nte_ajRlPpI>>(){}.getType());
//
//
//        try {
//            dd = compress(gson.toJson(pushInfoList));
//            Log.d("gson",dd);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//            Log.d("gson_error",ioException.toString());
//        }


    public void Blue(){
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Log.d("GGG",bluetoothAdapter.getName());

        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        for (BluetoothDevice device : bondedDevices) {
            String deviceName = device.getName();
            String deviceHardwareAddress = device.getAddress(); // MAC address

            Log.d("BBBBBB",deviceName+"  "+deviceHardwareAddress);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.toolbar_menu2:  drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
       return false;
    }

//    Navigation View
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(getApplicationContext(), "Navigation", Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
//               mNotificationManager.notify(NOTIFICATION_ID1,builder2.build());
                Toast.makeText(getApplicationContext(),"BTN1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(getApplicationContext(),"BTN2",Toast.LENGTH_SHORT).show();

                break;
            case R.id.toolbar_menu_img:
                Toast.makeText(getApplicationContext(),"Toolbar",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}