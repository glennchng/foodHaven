package com.example.glen9.foodhaven;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class foodMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        ViewGroup group = (ViewGroup)findViewById(R.id.linearLayout1);
        View v;
        for(int i = 0; i < group.getChildCount(); i++) {
            v = group.getChildAt(i);
            ViewGroup temp = (ViewGroup)findViewById(v.getId());
            View y;
            for(int x = 0; x < temp.getChildCount(); x ++){
                y = temp.getChildAt(x);
                y.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v){
        Integer counter;
        if (v instanceof TextView){
            counter = -1;
        }else{
            counter = 1;
        }
        if (v.getBackground() instanceof ColorDrawable){
            v.setBackground(null);
            findViewById(counter + v.getId()).setBackground(null);
        }else{
            v.setBackgroundColor(Color.RED);
            findViewById(counter + v.getId()).setBackgroundColor(Color.RED);
        }
    }
}
