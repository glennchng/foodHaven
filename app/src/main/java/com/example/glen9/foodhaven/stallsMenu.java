package com.example.glen9.foodhaven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stallsMenu extends AppCompatActivity {

    //private Button back;
    private TextView banmianBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stalls_menu);

        //back = (Button) findViewById(R.id.backButton);
        /*back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stallsMenu.this, menu_page.class);
                startActivity(intent);
            }
        });*/
        banmianBut = (TextView) findViewById(R.id.banmianBut);
        banmianBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stallsMenu.this, foodMenu.class);
                startActivity(intent);
            }
        });
    }
}
