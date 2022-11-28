package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    Button add;
    Button sub;
    Button mul;
    Button div;
    EditText et1;
    EditText et2;
    TextView et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initialize();

    }
    public void initialize(){
        et1=findViewById(R.id.first_number);
        et2=findViewById(R.id.second_number);
        et3=findViewById(R.id.result);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Double n1 = Double.parseDouble(et1.getText().toString());
                    Double n2 = Double.parseDouble(et2.getText().toString());

                    Double n3;
                    n3= addition(n1,n2);
                    et3.setText("Total value = "+ n3);
                }catch (Exception e) {

                }

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    Double n1 = Double.parseDouble(et1.getText().toString());
                    Double n2 = Double.parseDouble(et2.getText().toString());

                    Double n3;
                    n3= subtract(n1,n2);
                    et3.setText("Total value = "+ n3);
                }catch (Exception e) {

                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Double n1 = Double.parseDouble(et1.getText().toString());
                    Double n2 = Double.parseDouble(et2.getText().toString());

                    Double n3;
                    n3= multiply(n1,n2);
                    et3.setText("Total value = "+ n3);
                }catch (Exception e) {

                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Double n1 = Double.parseDouble(et1.getText().toString());
                    Double n2 = Double.parseDouble(et2.getText().toString());

                    Double n3;
                    n3= division(n1,n2);
                    et3.setText("Total value = "+ n3);
                }catch (Exception e) {

                }
            }
        });

    }
    public Double addition(Double n1,Double n2)
    {
        Double result = n1+n2;
        return result;
    }

    public Double subtract(Double n1,Double n2)
    {
        Double result =n1-n2;
        return result;

    }

    public Double multiply(Double n1,Double n2)
    {
        Double result =n1*n2;
        return result;

    }

    public Double division(Double n1,Double n2)
    {
        Double result =n1/n2;
        return result;

    }


}