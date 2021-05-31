package com.aoslec.frametest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnLinear1;
    Button btnLinear2;
    LinearLayout Linear1;
    LinearLayout Linear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinear1 = findViewById(R.id.btnLinear1);
        btnLinear2 = findViewById(R.id.btnLinear2);
        Linear1 = findViewById(R.id.Linear1);
        Linear2 = findViewById(R.id.Linear2);

        btnLinear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Linear1.setVisibility(v.VISIBLE);
                Linear2.setVisibility(v.INVISIBLE);
            }
        });

        btnLinear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Linear1.setVisibility(v.INVISIBLE);
                Linear2.setVisibility(v.VISIBLE);
            }
        });
    }
}