package com.aoslec.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearFirst, linearSecond, linearThird;
    Button mainBtn, secondBtn, thirdBtn;
    EditText height, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearFirst = findViewById(R.id.firstLinear);
        linearSecond = findViewById(R.id.secondLinear);
        linearThird = findViewById(R.id.thirdLinear);

        mainBtn = findViewById(R.id.mainBtn);
        secondBtn = findViewById(R.id.SecondBtn);
        thirdBtn = findViewById(R.id.ThirdBtn);

        height = findViewById(R.id.editHeight);
        weight = findViewById(R.id.editWeight);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.VISIBLE);
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.INVISIBLE);
                linearThird.setVisibility(v.VISIBLE);
            }
        });

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}