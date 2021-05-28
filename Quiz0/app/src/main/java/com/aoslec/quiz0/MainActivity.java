package com.aoslec.quiz0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // property
    Button buttonRed, buttonGreen, buttonBlue;
//    Button buttonRed;
//    Button buttonGreen;
//    Button buttonBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRed = findViewById(R.id.btnRed); // 연결시켜주는 느낌 (자바에서 쓰는 것 buttonRed / xml에서 쓰는 것 R.id.btnRed)
        buttonGreen = findViewById(R.id.btnGreen);
        buttonBlue = findViewById(R.id.btnBlue);

//        buttonRed.setOnClickListener(new View.OnClickListener() { // 버튼레드일 때까지 기다리는 것 -> 부르면 onClick 실행
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "빨간색 버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        buttonGreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "초록색 버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        buttonBlue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "파란색 버튼을 눌렀습니다!", Toast.LENGTH_SHORT).show();
//            }
//        });

        // new Ver.
        buttonRed.setOnClickListener(onClickListener); // 여기는 준비하는 느낌! listener는 준비하는 느낌
        buttonGreen.setOnClickListener(onClickListener);
        buttonBlue.setOnClickListener(onClickListener);

    } // 처음 킬 때는 이 메소드가 끝임 (onCreate) 딱 한 번만 실행됨 (계속 띄어놓는 상태가 유지됨) 두 번째 페이지는 오버랩 되는 것! 첫 번째 꺼지는 것 아님

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // id 값으로 어떤 값을 눌렀는지 구분하겠다 (v는 View임)
                String colorString = "";
                switch (v.getId()){
                    // R 붙으면 xml 이라고 생각하기! 그래서 R.id.btnRed 임! 뷰에 있는 id를 가져올꺼야! (view는 xml임)
                    case R.id.btnRed:
//                        Toast.makeText(MainActivity.this,"빨간색 버튼을 눌렀습니다!",Toast.LENGTH_SHORT).show();
                        colorString = "빨간색";
                        break;
                    case R.id.btnGreen:
                        colorString = "초록색";
                        break;
                    case R.id.btnBlue:
                        colorString = "파란색";
                        break;
                }
                Toast.makeText(MainActivity.this,colorString + " 버튼을 눌렀습니다!",Toast.LENGTH_SHORT).show();;
            }
        }; // 변수에 함수 기능을 추가한 것이기 때문에 ; 끝에 붙여주어야 함
}