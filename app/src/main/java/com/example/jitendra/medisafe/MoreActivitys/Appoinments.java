package com.example.jitendra.medisafe.MoreActivitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.jitendra.medisafe.R;

public class Appoinments extends AppCompatActivity {
    Button add_Appoinments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        add_Appoinments=(Button)findViewById(R.id.add_Appoinments);

        add_Appoinments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Appoinments.this, Add_Appointment.class);
                startActivity(intent);
                Appoinments.super.onBackPressed();
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
