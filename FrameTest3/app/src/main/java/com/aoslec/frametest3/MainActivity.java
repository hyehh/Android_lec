package com.aoslec.frametest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.mainButton1);
        button2 = findViewById(R.id.mainButton2);
        LinearLayout linear1 = findViewById(R.id.Linear1);
        LinearLayout linear2 = findViewById(R.id.Linear2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(v.VISIBLE);
                linear2.setVisibility(v.INVISIBLE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(v.INVISIBLE);
                linear2.setVisibility(v.VISIBLE);
            }
        });

    }
}