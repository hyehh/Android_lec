package com.aoslec.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 여기에서 선언하는 것 보다 밖에서 선언하는 게 정석임! 그렇게 하자
        Button btnCall = findViewById(R.id.call);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 메인액티비티에서 서브액티비티로 이동해라 정의해줌
                // 컴파일 되면 자바는 클라스 파일로 만들어줌
                // 여기에 MainActivity.this 말고 this 적어주면 안됨! 메소드가 여러개이기 때문
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                // intent 시작해라
                startActivity(intent);
            }
        });
    }
}