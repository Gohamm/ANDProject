package com.example.converterapp.Unit_converter_UI;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.converterapp.Frontpage_Main;
import com.example.converterapp.R;
import com.example.converterapp.UnitConversionModels.LengthConversion;
import com.example.converterapp.databinding.ActivityMain2Binding;
import com.example.converterapp.databinding.ActivityMainBinding;

public class MainActivity2 extends Frontpage_Main {
    EditText userInput;
    Spinner From_unit_Spinner;
    Spinner To_unit_Spinner;
    TextView tvResult;
    Button convertBtn;

    ActivityMain2Binding activityMain2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(activityMain2Binding.getRoot());
        allocateActivityTitle("mainActivity2");

        convertBtn = (Button) findViewById(R.id.convertBtn);
        userInput = (EditText) findViewById(R.id.userInput);
        From_unit_Spinner = (Spinner) findViewById(R.id.convertFrom);
        To_unit_Spinner = (Spinner) findViewById(R.id.convertTo);
        tvResult = (TextView) findViewById(R.id.tvResult);


        //populating spinners

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.units));

        From_unit_Spinner.setAdapter(arrayAdapter);
        To_unit_Spinner.setAdapter(arrayAdapter);
        To_unit_Spinner.setSelection(1); // so it does not start on the same value as the other spinner

        convertBtn.setOnClickListener(view -> {
            double userInputAmount;
            double tvResults;
            String From_unit;
            String To_Unit;

            LengthConversion lengthConversion = new LengthConversion();

            if(!userInput.getText().toString().equals("")) {
                userInputAmount = Double.parseDouble(userInput.getText().toString());
                From_unit = From_unit_Spinner.getSelectedItem().toString();
                To_Unit = To_unit_Spinner.getSelectedItem().toString();

                lengthConversion.setFrom_Unit(From_unit);
                lengthConversion.setTo_Unit(To_Unit);
                lengthConversion.setUserInput(userInputAmount);

                tvResults = lengthConversion.calculateOutput();
                lengthConversion.setConversionOutput(tvResults);
                tvResult.setText(lengthConversion.toString());
            } else {
                Log.i("missing userInput", "onClick: Failed ");
            }

        });
        


    }


}
