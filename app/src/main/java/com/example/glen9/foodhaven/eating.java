package com.example.glen9.foodhaven;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.Chronometer;

public class eating extends AppCompatActivity {
    private Button proceedScan;
    Timer timer;
    private Chronometer mchronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating);

        mchronometer = (Chronometer) findViewById(R.id.chronometer);
        mchronometer.start();
        proceedScan = (Button) (findViewById(R.id.toScanButton));
        proceedScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (eating.this, qrcode.class);
                startActivity(intent);
            }
        });
        timer = new Timer();
        timer.schedule(new TimerTask() {

            @SuppressLint("WrongConstant")
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        proceedScan.setEnabled(true);
                    }
                });

                //proceedScan.setVisibility(View.VISIBLE);


            }
        },4000);



    }
}
