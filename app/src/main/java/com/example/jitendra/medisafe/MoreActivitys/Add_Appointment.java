package com.example.jitendra.medisafe.MoreActivitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jitendra.medisafe.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Add_Appointment extends AppCompatActivity implements DatePickerFragment.DatePickerListener{
    Spinner add_doctor;
    ImageView backArrows;
    private ArrayList<Appointment_Item> appointment_items;
    Appointment_Adapter appointment_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__appointment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        backArrows=(ImageView)findViewById(R.id.backArrows);
        backArrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Add_Appointment.super.onBackPressed();
            }
        });

        initlist();
        add_doctor=(Spinner)findViewById(R.id.spinner);
        appointment_adapter =new Appointment_Adapter(this,appointment_items);
        add_doctor.setAdapter(appointment_adapter);
        add_doctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              /* Appointment_Item  clickitem =(Appointment_Item)parent.getItemAtPosition(position);
               String name=clickitem.getCountryName();
              Toast.makeText(getApplicationContext(),name + "Clicked",Toast.LENGTH_SHORT).show();*/

              if (position ==0)
              {

              }
              else if (position == 1)
              {

                  Intent intent=new Intent(Add_Appointment.this,Add_Doctor.class);
                  startActivity(intent);
              }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initlist() {
        appointment_items =new ArrayList<>();
        appointment_items.add(new Appointment_Item("None",R.drawable.doctor));
        appointment_items.add(new Appointment_Item("Add Doctor",R.drawable.add_btn));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);
        String date= DateFormat.getDateInstance().format(cal.getTime());
       // tvDisplayDate.setText(date);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
