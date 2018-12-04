package com.example.jitendra.medisafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class DeliteAuto extends AppCompatActivity implements AdapterView.OnItemClickListener {
    AutoCompleteTextView autoCompleteTextView;
    TextView tvDisplay;

    String restaurants[] = {
            "KFC",
            "Dominos",
            "Pizza Hut",
            "Burger King",
            "Subway",
            "Dunkin' Donuts",
            "Starbucks",
            "Cafe Coffee Day"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delite_auto);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.actv);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,restaurants);

        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        // fetch the user selected value
        String item = parent.getItemAtPosition(position).toString();

        // create Toast with user selected value
        Toast.makeText(DeliteAuto
                .this, "Selected Item is: \t" + item, Toast.LENGTH_LONG).show();

        // set user selected value to the TextView
        tvDisplay.setText(item);

    }
}