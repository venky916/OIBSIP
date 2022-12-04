package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Unit_Converter extends AppCompatActivity {

    TextView unit_converter;
    EditText value;
    Button feet;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);

        //Initializing weights
        feet = findViewById(R.id.foot);

        value =  findViewById(R.id.value);

        result =findViewById(R.id.result);


        //Adding  aclick event
        feet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ConvertFromCentimetersToFeet();

            }
        });


    }

    private void ConvertFromCentimetersToFeet() {
        // Convert kilo to Pound
        String cmString=value.getText().toString();



        // Convert string to num
        if(!cmString.trim().isEmpty()) {
            try {
                double cms = Double.parseDouble(cmString);
                double feet = cms / 30.480 ;

                result.setText(""+Math.round(feet*10000.0)/10000.0);
            }catch (Exception e) {

            }
        }
    }


}