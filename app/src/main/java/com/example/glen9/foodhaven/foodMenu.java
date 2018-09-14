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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class foodMenu extends AppCompatActivity implements View.OnClickListener {

    public ArrayList<String> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        ViewGroup group = (ViewGroup)findViewById(R.id.linearLayout1);
        View v;
        Integer counter = 0;

        for(int i = 0; i < group.getChildCount(); i++) {
            v = group.getChildAt(i);
            ViewGroup temp = (ViewGroup)findViewById(v.getId());
            View y;
            for(int x = 0; x < temp.getChildCount(); x ++){
                counter++;
                y = temp.getChildAt(x);
                y.setId(counter);
                y.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v){
        Integer counter;
        TextView t;
        Log.d("foodHaven",Integer.toString(v.getId()));
        if (v instanceof TextView){
            t = findViewById(v.getId());
            counter = -1;
        }else{
            counter = 1;
            t = findViewById(counter + v.getId());
        }
        if (v.getBackground() instanceof ColorDrawable){
            v.setBackground(null);
            findViewById(counter + v.getId()).setBackground(null);
            items.remove(t.getText().toString());
        }else{
            v.setBackgroundColor(Color.YELLOW);
            findViewById(counter + v.getId()).setBackgroundColor(Color.YELLOW);
            items.add(t.getText().toString());
        }
    }

    public void confirm(View v){
        if (items.size() == 0){
            Toast.makeText(getApplicationContext(),"You must select at least one!",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(this,OrderConfirm.class);
        intent.putStringArrayListExtra("items",items);
        startActivity(intent);
    }
}
