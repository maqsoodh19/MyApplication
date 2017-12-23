package com.example.maqso.myapplication;

import android.app.Service;
import android.app.usage.NetworkStatsManager;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.WifiManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;
    private Switch sw;
    private String sms = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertFunction();
        secondActivityFun();
        wifiChanger();

        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(Communicator obj) {
        sms = obj.getSms().toString();
        wifiStaesChange(sms);
    }
    /// creating alert function

    public void alertFunction() {

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Do You want to close this app?").setCancelable(false).setPositiveButton("Aho", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("nai", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.setTitle("HAi Hai");
                alertDialog.show();
            }
        });


    }

    /// gallery open some pics
    public void secondActivityFun() {
        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.maqso.myapplication.SecondActivity");
                startActivity(intent);
            }
        });
    }

    // wifi states changes
    public void wifiChanger() {
        sw = (Switch) findViewById(R.id.sbar);
        final WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        if (wifiManager.isWifiEnabled()) {
            sw.setChecked(true);
        }
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (sw.isChecked() == false) {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Wifi OFF", Toast.LENGTH_SHORT).show();

                } else {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Wifi On", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void wifiStaesChange(String str) {

        if (str.equals("1234")) {
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            sw.setChecked(true);
        }

    }


}
