package com.aoslec.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearFirst, linearSecond;
    Button mainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearFirst = findViewById(R.id.firstLinear);
        linearSecond = findViewById(R.id.secondLinear);

        mainBtn = findViewById(R.id.mainBtn);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.VISIBLE);
            }
        });

    }
}