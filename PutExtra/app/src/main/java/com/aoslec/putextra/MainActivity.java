package com.aoslec.putextra;

import androidx.annotation.Nullable;
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
                case R.id.btn_main1:
                    intent = new Intent(MainActivity.this, ThirdActivity.class);
                    intent.putExtra("userid", "admin");
                    intent.putExtra("password", 2222);
                    // Rvalue는 리턴값 (startActivity + ReturnV 값을 Rvalue에 넣어줘라고 요구 - 세번째 액티비티에서 보내준 Rvalue를 가져올 것임)
                    startActivityForResult(intent, Rvalue);
                    break;
                default:
                    break;
            }
        }
    };

    // ThirdActivity에서 setResult 쓰려면 이 메소드 반드시 있어야 함!!!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (resultCode){ // 여기에는 requestCode가 아니고 resultCode로 적어야 함! 그래야 ResultV와 Rvalue가 다를 때 다른 작업 가능!
            // 이렇게 쓰려고 static 잡아 놓음!
            case MainActivity.Rvalue:
                textView.setText("Return Value : " + data.getStringExtra("result"));
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}