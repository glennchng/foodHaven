package com.example.glen9.foodhaven;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class waitingFood extends AppCompatActivity {
    private Button cancelButton;
    Timer timer;
    private static final long timerCD = 30000;
    private TextView viewTimer;
    private CountDownTimer countDownTime;
    private long timeLeft = timerCD;
    private Timer calcTimer = new Timer();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_food);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (waitingFood.this,stallsMenu.class);
                startActivity(intent);
            }
        });


        viewTimer = findViewById(R.id.countDown);
        countDownTime = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                int minutes = (int) (timeLeft / 1000) / 60;
                int seconds = (int) (timeLeft / 1000) % 60;
                String timeleftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                viewTimer.setText(timeleftFormatted);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent (waitingFood.this, eating.class);
                startActivity(intent);
            }
        }.start();

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @SuppressLint("WrongConstant")
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        cancelButton.setEnabled(false);
                    }
                });

                //proceedScan.setVisibility(View.VISIBLE);


            }
        },5000);
    }
}
