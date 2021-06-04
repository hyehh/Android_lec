package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int Rvalue = 0;
    TextView textView = null;
    Button button = null;
    Button button1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_main);
        button = findViewById(R.id.btn_main);
        button1 = findViewById(R.id.btn_main1);

        button.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_main:
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    // startActivity 하기 전에 intent에다가 data를 주어야 함! (intent라는 버스에 사람을 태우는 것)
                    intent.putExtra("userid", "root");
                    // 값은 int든 string이든 아무거나 보낼 수 있다!
                    intent.putExtra("password", 1111);
                    startActivity(intent);
                    break;
            }
        }
    };
}