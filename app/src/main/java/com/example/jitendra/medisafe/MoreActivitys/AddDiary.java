package com.example.jitendra.medisafe.MoreActivitys;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.jitendra.medisafe.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddDiary extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    TextView date,timeText,color;
    TimePicker simpleTimePicker;

    TimePickerDialog timePickerDialog;
    Calendar calendara;
    int currentHour;
    int currentMinute;
    String amPm;
    ImageView add_color_img,backArrows;
    Dialog myDialog;

    CircleImageView circleImageView_color_1;
    TextView color_text;

    String text;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        date=(TextView)findViewById(R.id.date);
        timeText=(TextView)findViewById(R.id.timeText);
        color=(TextView)findViewById(R.id.color_text);
        backArrows=(ImageView) findViewById(R.id.backArrows);
        add_color_img=(ImageView) findViewById(R.id.add_color_img);
        simpleTimePicker = (TimePicker) findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        myDialog = new Dialog(this);

       circleImageView_color_1=(CircleImageView)findViewById(R.id.add_color_img) ;
        //color_text_main=(TextView) findViewById(R.id.color_text) ;
        color_text=(TextView) findViewById(R.id.color_text) ;
        //color1=(TextView) findViewById(R.id.texicolor1);
        circleImageView_color_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup();
            }
        });

        color_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup();
            }
        });
        backArrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddDiary.this,Diary.class);
                startActivity(intent);
                AddDiary.super.onBackPressed();

            /*  AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
              builder.setTitle("Are you sure?");
              builder.setMessage("You have unused changes." +
                      "Do you want to quit without saving?");
              builder.setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      finish();
                  }
              });
              builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      finish();
                  }
              });
              AlertDialog alertDialog= builder.create();
         //     alertDialog.show();*/
            }
        });


        circleImageView_color_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup();
            }
        });
        /*SharedPreferences sharedPreferences=getSharedPreferences("Color_name",MODE_PRIVATE);
        text=   sharedPreferences.getString("name","");

        color_text_main.setText(text);
*/
        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendara = Calendar.getInstance();
                currentHour = calendara.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendara.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(AddDiary.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        timeText.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(999);
                Toast.makeText(getApplicationContext(), "ca",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }



    public void ShowPopup() {
        final TextView txtclose;
       // final String textColor_string1;
        myDialog.setContentView(R.layout.color_lable);
        txtclose = (TextView) myDialog.findViewById(R.id.text2);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"TTRTRT",Toast.LENGTH_SHORT).show();
             /* //  textColor_string1 =txtclose.getText().toString();
                Intent intent=new Intent(AddDiary.this,AddDiary.class);
                SharedPreferences sharedPreferences=getSharedPreferences("Color_name",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
               // editor.putString("name", String.valueOf(textColor_string1));
                editor.commit();

                startActivity(intent);*/
                myDialog.dismiss();
            }
        });
        myDialog.show();

    }
    public void setDate(View view) {

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        date.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


}
