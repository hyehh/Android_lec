package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class ThirdActivity extends AppCompatActivity {

    final  static int ReturnV = 0;
    TextView textView = null;
    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView = findViewById(R.id.tv_third);
        button = findViewById(R.id.btn_third);

//        intent 위치 여기든 setOnClickListener 밑이든 상관 없다!
//        Intent intent = getIntent();
//        String userid = intent.getStringExtra("userid");
//        int password = intent.getIntExtra("password", 0);
//        textView.setText("User ID : " + userid + " / password : " + password);

        button.setOnClickListener(onClickListener);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        int password = intent.getIntExtra("password", 0);
        textView.setText("User ID : " + userid + " / password : " + password);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("result", "aaaa");
            // intent 받은 애가 날려줄 때는 startActivity 이거 아니고 setResult
            setResult(ReturnV, intent);
            // setResult는 onActivityResult 를 쓴다는 이야기
            finish();
        }
    };
}