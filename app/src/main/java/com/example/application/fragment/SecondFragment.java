package com.example.application.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.application.R;

import java.util.Set;


public class SecondFragment extends Fragment implements View.OnClickListener{

    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_second, container, false);
        button = (Button) myView.findViewById(R.id.btn_url);
        button.setOnClickListener(this);
        blueTooth();
        return myView;

    }

    private void blueTooth(){
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
//        Bluetooth 활성화 상태 체크
        Log.d("Bluetooth_isEnable",String.valueOf(adapter.isEnabled()));
        Set<BluetoothDevice> device = adapter.getBondedDevices();
        for ( BluetoothDevice device1: device){
            Log.d("Bluetooth_device",device1.getAddress());
            Log.d("Bluetooth_device",device1.getName());
        }


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_url:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"));
                startActivity(intent);
                break;
        }
    }
}