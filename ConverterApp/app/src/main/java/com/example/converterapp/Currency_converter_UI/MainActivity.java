package com.example.converterapp.Currency_converter_UI;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.converterapp.Frontpage_Main;
import com.example.converterapp.R;
import com.example.converterapp.databinding.ActivityMainBinding;


public class MainActivity extends Frontpage_Main {

    Button convert_button;
    EditText et_firstConversion;
    TextView conversion_result;
    Spinner convertTo;
    Spinner convertFrom;


    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        allocateActivityTitle("mainActivity");




        et_firstConversion = (EditText) findViewById(R.id.et_firstConversion);
        conversion_result = (TextView) findViewById(R.id.conversion_result);
        convertFrom = (Spinner) findViewById(R.id.spinner_firstConversion);
        convertTo = (Spinner) findViewById(R.id.spinner_secondConversion);
        convert_button = (Button) findViewById(R.id.convert_button);


        String[] currencies = {"DKK", "EUR", "USD", "AUS", "RUB", "SEK", "IDR"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        convertFrom.setAdapter(adapter);
        convertFrom.setSelection(0);


        convertTo.setAdapter(adapter);
        convertTo.setSelection(1);


        convert_button.setOnClickListener(view -> {
         // get conversion based on the 2 spinners converFrom and ConvertTo + the amount to be converted
        });

    }

    





}









