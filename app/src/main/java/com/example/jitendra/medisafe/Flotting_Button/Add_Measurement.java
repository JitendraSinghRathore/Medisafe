package com.example.jitendra.medisafe.Flotting_Button;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendra.medisafe.R;
import com.example.jitendra.medisafe.Starting_Page.Navigation;

public class Add_Measurement extends AppCompatActivity {
    public boolean showText = false;
    android.app.ActionBar actionBar;
    TextView textView;
    Switch switchhdl;
    ImageView backArrows;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__measurement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        switchhdl=(Switch)findViewById(R.id.switchhdl);


        textView=(TextView)findViewById(R.id.text1);
        final String text = textView.getText().toString();

        switchhdl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean off){
                if(off)
                {
                    /*switchhdl.setChecked(true);
                    switchhdl.isChecked();
                    Intent myIntent = new Intent(Add_Measurement.this,Add_Medication.class);
                    myIntent.putExtra("Cholesterol",text);
                    startActivity(myIntent);*/

                }
                else
                {
                    //Do something when Switch is off/unchecked
                    textView.setText("Switch is off.....");
                }
            }
        });
        //Custom Toolbar is add onto activity
        actionBar=getActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.addmeasurementcustom, null);
        getSupportActionBar().setCustomView(mCustomView);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        //back press icon click apply
        backArrows=(ImageView)findViewById(R.id.backArrows);
        backArrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Add_Measurement.this,Navigation.class);
                startActivity(intent);
            }
        });
    }


    //Back Press Methods click apply
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Add_Measurement.this, Navigation.class);
        startActivity(intent);
        super.onBackPressed();




    }
}
