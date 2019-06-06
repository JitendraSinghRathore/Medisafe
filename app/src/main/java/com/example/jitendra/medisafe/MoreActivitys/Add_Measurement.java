package com.example.jitendra.medisafe.MoreActivitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.jitendra.medisafe.R;

public class Add_Measurement extends AppCompatActivity {
    public boolean showText = false;
    android.app.ActionBar actionBar;
    TextView textView;
    Switch switchhdl;
    ImageView backArrows;
    String text;
    private Toolbar toolbar;
    private TextView text1;
    private LinearLayout layoutHDL;
    private TextView text2;
    private Switch switch1;
    private LinearLayout layoutLDL;
    private Switch switch2;
    private LinearLayout layoutTriglycerides;
    private Switch switch3;
    private TextView text3;
    private LinearLayout layoutbodyFat;
    private LinearLayout layoutCaloriesConsumed;
    private Switch switch4;
    private LinearLayout layoutDailySteps;
    private Switch switch5;
    private LinearLayout layoutWeight;
    private Switch switch6;
    private TextView glucose;
    private LinearLayout layoutCaloriesExpended;
    private Switch switch7;
    private LinearLayout layoutA1C;
    private Switch switch8;
    private LinearLayout layoutBloodGlucose;
    private Switch switch9;
    private TextView hiv;
    private LinearLayout layoutCD4;
    private Switch switch10;
    private LinearLayout layoutCD4Cell;
    private Switch switch11;
    private LinearLayout layoutHivviral;
    private Switch switch12;
    private TextView imaging;
    private LinearLayout layoutTScore;
    private Switch switch13;
    private TextView lab;
    private LinearLayout layoutCreatinine;
    private Switch switch14;
    private LinearLayout layoutEgfr;
    private Switch switch15;
    private TextView other;
    private LinearLayout layoutBowel;
    private Switch switch16;
    private LinearLayout layoutInr;
    private Switch switch17;
    private LinearLayout layoutMoodLevel;
    private Switch switch18;
    private LinearLayout layoutPeakFlow;
    private Switch switch19;
    private LinearLayout layoutPainLevel;
    private Switch switch20;
    private LinearLayout layoutSpO2;
    private Switch switch21;
    private TextView vitals;
    private LinearLayout layoutBloodPressure;
    private Switch switch22;
    private LinearLayout layoutPulse;
    private Switch switch23;
    private LinearLayout layoutTempera;
    private Switch switch24;
    String text1_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__measurement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        textView=(TextView)findViewById(R.id.text1);
        final String text = textView.getText().toString();


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
                Intent intent=new Intent(Add_Measurement.this,Measurment.class);
                startActivity(intent);
            }
        });


    }

    public  void clickevent(View view)
    {

    }


    //Back Press Methods click apply
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Add_Measurement.this, Measurment.class);
        startActivity(intent);
        super.onBackPressed();

    }



    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-05-02 15:48:34 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        toolbar = (Toolbar)findViewById( R.id.toolbar );
       // cholestrol = (TextView)findViewById( R.id.cholestrol );
        layoutHDL = (LinearLayout)findViewById( R.id.layoutHDL );
        text1 = (TextView)findViewById( R.id.text1 );
        switch1 = (Switch)findViewById( R.id.switch1 );
        layoutLDL = (LinearLayout)findViewById( R.id.layoutLDL );
        switch2 = (Switch)findViewById( R.id.switch2 );
        layoutTriglycerides = (LinearLayout)findViewById( R.id.layoutTriglycerides );
        switch3 = (Switch)findViewById( R.id.switch3 );
     //   fitness = (TextView)findViewById( R.id.fitness );
        layoutbodyFat = (LinearLayout)findViewById( R.id.layoutbodyFat );
        switch3 = (Switch)findViewById( R.id.switch3 );
        layoutCaloriesConsumed = (LinearLayout)findViewById( R.id.layoutCaloriesConsumed );
        switch4 = (Switch)findViewById( R.id.switch4 );
        layoutDailySteps = (LinearLayout)findViewById( R.id.layoutDailySteps );
        switch5 = (Switch)findViewById( R.id.switch5 );
        layoutWeight = (LinearLayout)findViewById( R.id.layoutWeight );
        switch6 = (Switch)findViewById( R.id.switch6 );
        glucose = (TextView)findViewById( R.id.glucose );
        layoutCaloriesExpended = (LinearLayout)findViewById( R.id.layoutCaloriesExpended );
        switch7 = (Switch)findViewById( R.id.switch7 );
        layoutA1C = (LinearLayout)findViewById( R.id.layoutA1C );
        switch8 = (Switch)findViewById( R.id.switch8 );
        layoutBloodGlucose = (LinearLayout)findViewById( R.id.layoutBloodGlucose );
        switch9 = (Switch)findViewById( R.id.switch9 );
        hiv = (TextView)findViewById( R.id.hiv );
        layoutCD4 = (LinearLayout)findViewById( R.id.layoutCD4 );
        switch10 = (Switch)findViewById( R.id.switch10 );
        layoutCD4Cell = (LinearLayout)findViewById( R.id.layoutCD4_cell );
        switch11 = (Switch)findViewById( R.id.switch11 );
        layoutHivviral = (LinearLayout)findViewById( R.id.layoutHivviral );
        switch12 = (Switch)findViewById( R.id.switch12 );
        imaging = (TextView)findViewById( R.id.imaging );
        layoutTScore = (LinearLayout)findViewById( R.id.layoutTScore );
        switch13 = (Switch)findViewById( R.id.switch13 );
        lab = (TextView)findViewById( R.id.lab );
        layoutCreatinine = (LinearLayout)findViewById( R.id.layoutCreatinine );
        switch14 = (Switch)findViewById( R.id.switch14 );
        layoutEgfr = (LinearLayout)findViewById( R.id.layoutEgfr );
        switch15 = (Switch)findViewById( R.id.switch15 );
        other = (TextView)findViewById( R.id.other );
        layoutBowel = (LinearLayout)findViewById( R.id.layoutBowel );
        switch16 = (Switch)findViewById( R.id.switch16 );
        layoutInr = (LinearLayout)findViewById( R.id.layoutInr );
        switch17 = (Switch)findViewById( R.id.switch17 );
        layoutMoodLevel = (LinearLayout)findViewById( R.id.layoutMoodLevel );
        switch18 = (Switch)findViewById( R.id.switch18 );
        layoutPeakFlow = (LinearLayout)findViewById( R.id.layoutPeakFlow );
        switch19 = (Switch)findViewById( R.id.switch19 );
        layoutPainLevel = (LinearLayout)findViewById( R.id.layoutPainLevel );
        switch20 = (Switch)findViewById( R.id.switch20 );
        layoutSpO2 = (LinearLayout)findViewById( R.id.layoutSpO2 );
        switch21 = (Switch)findViewById( R.id.switch21 );
        vitals = (TextView)findViewById( R.id.vitals );
        layoutBloodPressure = (LinearLayout)findViewById( R.id.layoutBloodPressure );
        switch22 = (Switch)findViewById( R.id.switch22 );
        layoutPulse = (LinearLayout)findViewById( R.id.layoutPulse );
        switch23 = (Switch)findViewById( R.id.switch23 );
        layoutTempera = (LinearLayout)findViewById( R.id.layoutTempera );
        switch24 = (Switch)findViewById( R.id.switch24 );
    }


    public void doSomthing(View view) {

        switch (view.getId())
        {
            case R.id.switch1:
                text1_a=textView.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences("Measurement",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("TEXT1",text1_a);
                editor.commit();
                break;
        }
    }
}
