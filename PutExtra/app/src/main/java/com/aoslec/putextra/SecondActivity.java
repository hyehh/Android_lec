package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView = null;
    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv_second);
        button = findViewById(R.id.btn_second);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        // int는 defaultValue라고 데이터를 안넣었을 때 default값을 넣어줘야 함!
        int password = intent.getIntExtra("password", 0);
        textView.setText("UserId : " + userid + " / Password : " + password);

        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}