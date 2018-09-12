package com.example.glen9.foodhaven;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startEat extends AppCompatActivity {
    private Button startEat;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_eat);
        startEat = (Button) findViewById(R.id.startEatButton);
        startEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startEat.this,eating.class);
                startActivity(intent);
            }
        });
    }
}
