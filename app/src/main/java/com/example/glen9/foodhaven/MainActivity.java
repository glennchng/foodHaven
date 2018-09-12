package com.example.glen9.foodhaven;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText id;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText)findViewById(R.id.inputLogin);
        password = (EditText)findViewById(R.id.inputPassword);
        login = (Button)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(id.getText().toString(), password.getText().toString());
            }
        });
    }

    @SuppressLint("ShowToast")
    private void validate(String userId, String userPassword){
        if((userId.equals("admin")) && (userPassword.equals("123"))){
            Intent intent = new Intent(MainActivity.this,waitingFood.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"ID:admin;PW:123",Toast.LENGTH_LONG).show();
        }
    }
}
