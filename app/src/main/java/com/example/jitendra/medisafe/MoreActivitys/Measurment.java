package com.example.jitendra.medisafe.MoreActivitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.medisafe.R;
import com.example.jitendra.medisafe.Starting_Page.Navigation;

public class Measurment extends AppCompatActivity {

    TextView mesurement;
    Button add_measurement;
    String tex;
    ImageView backArrows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mesurement=(TextView)findViewById(R.id.measurementa);
        add_measurement=(Button)findViewById(R.id.add_measurement);
        backArrows=(ImageView) findViewById(R.id.backArrows);

        backArrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Measurment.this, Navigation.class);
                startActivity(intent);
                Measurment.super.onBackPressed();
            }
        });

        add_measurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Measurment.this, Add_Measurement.class);
                startActivity(intent);
                Measurment.super.onBackPressed();
            }
        });

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("Measurement",MODE_PRIVATE);
        tex=sharedPreferences.getString("TEXT1","");
        mesurement.setText(tex);




    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
