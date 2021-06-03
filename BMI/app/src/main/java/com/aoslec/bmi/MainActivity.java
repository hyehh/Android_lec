package com.aoslec.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearFirst, linearSecond, linearThird, linearFourth;
    Button mainBtn, secondBtn, thirdBtn, fourthBtn;
    EditText height, weight;

    double cm, kg, calResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearFirst = findViewById(R.id.firstLinear);
        linearSecond = findViewById(R.id.secondLinear);
        linearThird = findViewById(R.id.thirdLinear);
        linearFourth = findViewById(R.id.fourthLinear);

        mainBtn = findViewById(R.id.mainBtn);
        secondBtn = findViewById(R.id.SecondBtn);
        thirdBtn = findViewById(R.id.ThirdBtn);
        fourthBtn = findViewById(R.id.FourthBtn);

        height = findViewById(R.id.editHeight);
        weight = findViewById(R.id.editWeight);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.VISIBLE);
                linearThird.setVisibility(v.INVISIBLE);
                linearFourth.setVisibility(v.INVISIBLE);
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.INVISIBLE);
                linearThird.setVisibility(v.VISIBLE);
                linearFourth.setVisibility(v.INVISIBLE);
            }
        });

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.INVISIBLE);
                linearThird.setVisibility(v.INVISIBLE);
                linearFourth.setVisibility(v.VISIBLE);

                cm = Double.parseDouble(height.getText().toString());
                kg = Double.parseDouble(weight.getText().toString());
                calResult = kg / (cm * 0.01 * cm * 0.01);
                String result = String.format("%.2f", calResult);
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}