package com.aoslec.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.call);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                이거 많이 사용 안함
//                AlertDialog.Builder bld = new AlertDialog.Builder(MainActivity.this);
//                bld.setTitle("알립니다.");
//                bld.setMessage("대화상자를 열었습니다");
//                bld.setIcon(R.mipmap.ic_launcher);
//                bld.show();

                // 이게 많이 사용하는 방식
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("알립니다.")
                        .setMessage("대화상자를 열었습니다")
                        .setIcon(R.drawable.w1)
                        // setCancelable 사용 안하면 닫기버튼 눌러도 되고 아무곳이나 눌러도 다이얼 사라짐
                        // setCancelable 사용하면 닫기버튼 클릭 시에만 사라짐
                        .setCancelable(false)
                        .setPositiveButton("닫기",null)
                        .show();
            }
        });
    }
}