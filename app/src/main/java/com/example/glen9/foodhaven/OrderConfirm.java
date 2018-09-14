package com.example.glen9.foodhaven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderConfirm extends AppCompatActivity {

    TextView temp;
    ListView list;
    ArrayAdapter<String> itemsAdapter;

    public ArrayList<String> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        items = getIntent().getStringArrayListExtra("items");
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        list = (ListView) findViewById(R.id.dynamic);
        list.setAdapter(itemsAdapter);
    }

    public void confirm(View v){
        Intent intent = new Intent(this,waitingFood.class);
        startActivity(intent);
    }

    public void restart(View v){
        Intent intent = new Intent(this, foodMenu.class);
        startActivity(intent);
    }
}
