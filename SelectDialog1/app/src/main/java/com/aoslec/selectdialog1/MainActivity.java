package com.aoslec.selectdialog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mSelect = 0;
    boolean[] mSelectMulti = {false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.call);

        // 기본
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("음식을 선택하세요")
//                        .setIcon(R.mipmap.ic_launcher)
//                        .setItems(R.array.foods,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        String[] foods = getResources().getStringArray(R.array.foods);
//                                        TextView textView = findViewById(R.id.text);
//                                        textView.setText("선택한 음식 : " + foods[which]);
//                                    }
//                                }
//                        )
//                        .setCancelable(false)
//                        .setNegativeButton("취소", null)
//                        .show();
//            }
//        });

        // 라디오 버튼
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("음식을 선택하세요")
//                        .setIcon(R.mipmap.ic_launcher)
//                        .setSingleChoiceItems(R.array.foods, mSelect,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        // 번호만 집어 넣기 (위치 번호만 알게 되면 배열에서 그 번호 쓰면 글자 나올 것임)
//                                        mSelect = which;
//                                    }
//                                }
//                        )
//                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        String[] foods = getResources().getStringArray(R.array.foods);
//                                        TextView textView = findViewById(R.id.text);
//                                        textView.setText("선택한 음식 : " + foods[mSelect]);
//
//                                    }
//                                }
//                        )
//                        .setNegativeButton("취소", null)
//                        .show();
//            }
//        });

        // 체크 박스
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(R.array.foods, mSelectMulti,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        // 여기에서 체크박스에 선택된 것들은 true로 바뀜
                                        mSelectMulti[which] = isChecked;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 데이터 값 알기
                                String[] foods = getResources().getStringArray(R.array.foods);
                                TextView textView = findViewById(R.id.text);
                                String result = "선택한 음식 : ";
                                for(int i=0;  i<mSelectMulti.length; i++){
                                    if(mSelectMulti[i]){ // mSelectMulti[i] == true 이거랑 똑같은 거임!
                                        result += foods[i] + " / ";
                                    }
                                }
                                textView.setText(result);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
    }
}