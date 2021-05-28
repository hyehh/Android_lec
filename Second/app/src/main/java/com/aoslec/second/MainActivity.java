package com.aoslec.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // property (=field)
    Button button; // int = 0; 처럼 버튼 이름 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnOk);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 어디에 보이겠다, 무엇을 보이겠다, 얼마동안 보이겠다, 그럼 보여줘라!
                // context 는 현재의 상태와 위치를 알고 있는 것임
                Toast.makeText(MainActivity.this, "버튼을 누르다", Toast.LENGTH_SHORT).show();
            }
        });

    }
}