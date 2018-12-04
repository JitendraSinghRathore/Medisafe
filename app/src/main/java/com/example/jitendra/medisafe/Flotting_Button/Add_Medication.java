package com.example.jitendra.medisafe.Flotting_Button;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendra.medisafe.DeliteAuto;
import com.example.jitendra.medisafe.Starting_Page.Navigation;
import com.example.jitendra.medisafe.R;

import java.util.ArrayList;

public class Add_Medication extends AppCompatActivity implements AdapterView.OnItemClickListener{
    AutoCompleteTextView autocomplete;
    Button nextdelault,nextchange;
    Dialog myDialog;
    ImageView crossclick,timeremhide,timeremshow;
    CardView timeremendracard;
    android.app.ActionBar actionBar;

    String[] arr = {"Ajmer","Alwar","Banswara","Baran Barmer",
            "Bharatpur","Bhilwara","Bikaner","Bundi","Chittorgarh","Churu","Dausa","Dholpur","Dungarpur","Hanumangarh","Jaipur",
            "Jaisalmer","Jalor","Jhalawar","Jhunjhunu","Jodhpur","Karauli","Kota","Nagaur","Pali","Pratapgarh",
            "Rajsamand","Sawai","Madhopur","Sikar","Sirohi","Sri","Ganganagar","Tonk","Udaipur"};



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__medication);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        actionBar=getActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.addmedicationcustom, null);
        getSupportActionBar().setCustomView(mCustomView);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        autocomplete = (AutoCompleteTextView) findViewById(R.id.autocum);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);
        autocomplete.setOnItemClickListener(this);
        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);
        nextdelault=(Button)findViewById(R.id.nextdefault);
        nextchange=(Button)findViewById(R.id.nextchange);
        timeremhide=(ImageView)findViewById(R.id.timereminderhide);
        timeremshow=(ImageView)findViewById(R.id.timeremindershow);
        timeremendracard=(CardView)findViewById(R.id.timeremindercard);
        timeremhide.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            timeremhide.setVisibility(View.INVISIBLE);
                            timeremshow.setVisibility(View.VISIBLE);

                        }
                    });
        timeremshow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        timeremshow.animate().rotation(180);
                        timeremshow.setVisibility(View.INVISIBLE);
                        timeremhide.setVisibility(View.VISIBLE);

                    }
                });

        crossclick=(ImageView)findViewById(R.id.crossaddmedication);
        crossclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dilogbox();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        nextdelault.setVisibility(View.INVISIBLE);
        nextchange.setVisibility(View.VISIBLE);

        //String item = parent.getItemAtPosition(position).toString();
       // Toast.makeText(Add_Medication.this, "Selected Item is:" + item, Toast.LENGTH_LONG).show();
        }
    public void dilogbox() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Add_Medication.this);
        builder.setTitle("Are you sure you want to exit?");
        builder.setMessage("You have unsaved changes.\nDo you want to quit without saving?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent=new Intent(Add_Medication.this,Navigation.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        android.app.AlertDialog alert = builder.create();
        alert.show();

    }
    @Override
    public void onBackPressed() {
       dilogbox();

    }

}
