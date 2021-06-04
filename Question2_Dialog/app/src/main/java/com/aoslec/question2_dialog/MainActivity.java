package com.aoslec.question2_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    int a, b, result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);
        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("좌변을 선택하십시오")
                        .setCancelable(false)
                        .setPositiveButton("4", firstClick)
                        .setNegativeButton("3", firstClick)
                        .show();
            }
        });
    }

    DialogInterface.OnClickListener firstClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                a = 4;
            }else {
                a = 3;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문")
                    .setMessage("우변을 선택하십시오")
                    .setCancelable(false)
                    .setPositiveButton("4", secondClick)
                    .setNegativeButton("3", secondClick)
                    .show();
        }
    };

    DialogInterface.OnClickListener secondClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                b = 4;
            }else {
                b = 3;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문")
                    .setMessage("어떤 연산을 하시겠습니까?")
                    .setCancelable(false)
                    .setPositiveButton("곱셈", thirdClick)
                    .setNegativeButton("덧셈", thirdClick)
                    .show();
        }
    };

    DialogInterface.OnClickListener thirdClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                result = a * b;
            }else {
                result = a + b;
            }
            textView.setText("연산 결과 : " + result);

        }
    };

}