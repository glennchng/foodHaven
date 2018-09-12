package com.example.glen9.foodhaven;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.Toast;

public class menu_page extends AppCompatActivity {

    private ImageButton menuButton;
    private ImageButton toQueue;
    //private Button backButton;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        toQueue = (ImageButton) findViewById(R.id.queueButton);
        toQueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_page.this,queueSystem.class);
                startActivity(intent);
            }
        });
        menuButton = (ImageButton) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_page.this, stallsMenu.class);
                startActivity(intent);
            }
        });


        /*
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_page.this,MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
}

/*<Button
        android:id="@+id/backButton"
                style="@android:style/Widget.DeviceDefault.Button.Inset"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Back"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintStart_toStartOf="parent" />*/