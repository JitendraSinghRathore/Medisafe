package com.example.jitendra.medisafe.Starting_Page;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendra.medisafe.R;

import java.util.ArrayList;
import java.util.List;

public class Profile_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner_gender,spinner_dob;
    List<String> gender,dob;
    ArrayAdapter<String> gender_Adapter,dob_Adapter;
    String gender_type,date;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    String frist_name,last_name,zipcode,fullname;
    TextView save;
    Button signup;
    EditText f_name,l_name,zipcodea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView=(ImageView)findViewById(R.id.Exit);
        save=(TextView) findViewById(R.id.save);
        signup=(Button) findViewById(R.id.button_sing_up);
        f_name=(EditText) findViewById(R.id.f_name);
        l_name=(EditText) findViewById(R.id.l_name);
        zipcodea=(EditText) findViewById(R.id.zipcode);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile_Activity.this,Navigation.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile_Activity.this,Sign_Up.class);
                startActivity(intent);

             /*   frist_name=f_name.getText().toString();
                last_name= l_name.getText().toString();
                zipcode=zipcodea.getText().toString();
                fullname=frist_name+last_name;*/

               /* if (fullname.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter name", Toast.LENGTH_SHORT).show();
                }
                else if (zipcode.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter Pincode", Toast.LENGTH_SHORT).show();
                }
                else if (gender_type.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter Gender", Toast.LENGTH_SHORT).show();
                }
                else if (date.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter Dob", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(Profile_Activity.this,Navigation.class);
                   *//* intent.putExtra("name",fullname);
                    intent.putExtra("gender",gender_type);
                    intent.putExtra("Dob",date);
                    intent.putExtra("pin code",zipcode);*//*
                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", fullname);
                    editor.putString("Gender", gender_type);
                    editor.putString("Dob", date);
                    editor.putString("pin code", zipcode);
                    editor.commit();
                    startActivity(intent);
                }
*/
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frist_name=f_name.getText().toString();
                last_name= l_name.getText().toString();
                zipcode=zipcodea.getText().toString();
                fullname=frist_name+last_name;

                if (fullname.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter name", Toast.LENGTH_SHORT).show();
                }
                else if (zipcode.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter Pincode", Toast.LENGTH_SHORT).show();
                }
                else if (gender_type.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter Gender", Toast.LENGTH_SHORT).show();
                }
                else if (date.equals(""))
                {
                    Toast.makeText(Profile_Activity.this,"enter Dob", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(Profile_Activity.this,Navigation.class);
                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", fullname);
                    editor.putString("Gender", gender_type);
                    editor.putString("Dob", date);
                    editor.putString("pin code", zipcode);
                    editor.commit();
                    startActivity(intent);
                }


            }

        });

        spinner_gender = (Spinner) findViewById(R.id.spinner_gender);
        gender = new ArrayList<String>();
        gender.add("Gender");
        gender.add("Female");
        gender.add("Male");
        gender.add("Other");
        spinner_gender.setOnItemSelectedListener(this);
        gender_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        gender_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(gender_Adapter);

        spinner_dob = (Spinner) findViewById(R.id.spinner_dob);
        dob = new ArrayList<String>();
        dob.add("Birth Year");
        dob.add("2001");
        dob.add("2000");
        dob.add("1999");
        dob.add("1998");
        dob.add("1997");
        dob.add("1996");
        dob.add("1995");
        dob.add("1994");
        dob.add("1993");
        dob.add("1992");
        dob.add("1991");
        dob.add("1990");
        spinner_dob.setOnItemSelectedListener(this);
        dob_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dob);
        dob_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_dob.setAdapter(dob_Adapter);






    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()){
            case R.id.spinner_gender :
                Toast.makeText(getApplicationContext(), gender.get(i),Toast.LENGTH_SHORT).show();
                gender_type = adapterView.getItemAtPosition(i).toString();

                break;
            case R.id.spinner_dob :
                Toast.makeText(getApplicationContext(), dob.get(i),Toast.LENGTH_SHORT).show();
                date = adapterView.getItemAtPosition(i).toString();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

   /* @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(Profile_Activity.this,i,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
}
