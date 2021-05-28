package com.aoslec.quiz0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // property
    Button buttonRed;
    Button buttonGreen;
    Button buttonBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRed = findViewById(R.id.btnRed); // 연결시켜주는 느낌 (자바에서 쓰는 것 buttonRed / xml에서 쓰는 것 R.id.btnRed)
        buttonGreen = findViewById(R.id.btnGreen);
        buttonBlue = findViewById(R.id.btnBlue);

        buttonRed.setOnClickListener(new View.OnClickListener() { // 버튼레드일 때까지 기다리는 것 -> 부르면 onClick 실
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "빨간색 버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "초록색 버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "파란색 버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}