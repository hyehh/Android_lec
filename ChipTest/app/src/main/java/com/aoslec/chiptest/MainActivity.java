package com.aoslec.chiptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    Chip chip1, chip2, chip3;
    ChipGroup chipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chip1 = (Chip) findViewById(R.id.chip1);
        chip2 = (Chip) findViewById(R.id.chip2);
        chip3 = (Chip) findViewById(R.id.chip3);

        chip2.setText("이제 되라");

        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "chip1 clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}