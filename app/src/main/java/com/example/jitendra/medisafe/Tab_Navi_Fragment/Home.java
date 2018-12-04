package com.example.jitendra.medisafe.Tab_Navi_Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jitendra.medisafe.Flotting_Button.Add_Measurement;
import com.example.jitendra.medisafe.Flotting_Button.Add_Medication;
import com.example.jitendra.medisafe.R;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class Home extends Fragment {
    private boolean fabExpanded = false;
    private FloatingActionButton fabSettings;
    private LinearLayout layoutFabSave;
    private LinearLayout layoutFabEdit;
    private LinearLayout layoutFabPhoto;
    LinearLayout layoutAddDose,layoutAddMeasurement,layoutAddMedication;
    //CalendarView calendarView;
    private HorizontalCalendar horizontalCalendar;


    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        fabSettings = (FloatingActionButton) view.findViewById(R.id.fabSetting);
        layoutFabSave = (LinearLayout) view.findViewById(R.id.layoutAddDose);
        layoutFabEdit = (LinearLayout) view.findViewById(R.id.layoutAddMeasurement);
        layoutFabPhoto = (LinearLayout) view.findViewById(R.id.layoutAddMedication);
        fabSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabExpanded == true){
                    closeSubMenusFab();
                } else {
                    openSubMenusFab();
                }
            }
        });

        //Only main FAB is visible in the beginning
        closeSubMenusFab();

        //Calender code
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EEE")
                .textSize(12f, 16f, 12f)
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.BLACK, Color.BLUE)
                .end()

                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                Toast.makeText(getContext(), DateFormat.format("EEE, MMM d, yyyy", date) + " is selected!", Toast.LENGTH_SHORT).show();
            }

        });

        //Apply Click event on FloatingButton All Linearlayout and Image code below
        layoutAddMedication=(LinearLayout)view.findViewById(R.id.layoutAddMedication);
        layoutAddMeasurement=(LinearLayout)view.findViewById(R.id.layoutAddMeasurement);
        layoutAddDose=(LinearLayout)view.findViewById(R.id.layoutAddDose);

        layoutAddMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),Add_Medication.class);
                startActivity(intent );
            }
        });

        layoutAddMeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),Add_Measurement.class);
                startActivity(intent);
            }
        });

        layoutAddDose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    //Click event on FloatingButton replace image
    private void closeSubMenusFab(){
        layoutFabSave.setVisibility(View.INVISIBLE);
        layoutFabEdit.setVisibility(View.INVISIBLE);
        layoutFabPhoto.setVisibility(View.INVISIBLE);
        fabSettings.setImageResource(R.drawable.pp);
        fabSettings.setSize(20);
        fabExpanded = false;
    }

    //Opens FAB submenus
    private void openSubMenusFab(){
        layoutFabSave.setVisibility(View.VISIBLE);
        layoutFabEdit.setVisibility(View.VISIBLE);
        layoutFabPhoto.setVisibility(View.VISIBLE);
        //Change settings icon to 'X' icon
        fabSettings.setImageResource(R.drawable.cr);
        fabExpanded = true;
    }


}
