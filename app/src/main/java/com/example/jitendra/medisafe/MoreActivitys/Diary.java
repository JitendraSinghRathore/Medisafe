package com.example.jitendra.medisafe.MoreActivitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jitendra.medisafe.R;
import com.example.jitendra.medisafe.Tab_Navi_Fragment.More;

import java.util.Calendar;

public class Diary<DatePicker> extends AppCompatActivity {
    Button add_diary;
    ImageView back_Diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        add_diary=(Button)findViewById(R.id.add_diary);
        back_Diary=(ImageView)findViewById(R.id.Exit);

        add_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Diary.this, AddDiary.class);
                startActivity(intent);
                //Diary.super.onBackPressed();
            }
        });

        back_Diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Diary.super.onBackPressed();
            }
        });




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
