package com.example.jitendra.medisafe.Starting_Page;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jitendra.medisafe.R;

public class Splash_Screen extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        getSupportActionBar().hide();
       handler=new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent=new Intent(Splash_Screen.this,Navigation.class);
               startActivity(intent);
           }
       },500);
    }
}
