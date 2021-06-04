package com.aoslec.orderdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.call);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이렇게 만든 linear를 alertdialog에 넣어줄 것임
                final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.order, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("주문 정보를 입력하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        // 우리가 만든 xml
                        .setView(linear)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 그냥 findViewById 적으면 activity_main 에서 찾으려고 함
                                EditText product = linear.findViewById(R.id.product);
                                EditText number = linear.findViewById(R.id.number);
                                CheckBox paymethod = linear.findViewById(R.id.paymethod);
                                TextView textView = findViewById(R.id.text);
                                // 삼항 연산자 사용하기! if문 사용하면 너무 복잡해짐
                                textView.setText("주문정보 : " + product.getText() + "상품, " + number.getText() + "개 " + (paymethod.isChecked() ? "착불 결제" : ""));
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView textView = findViewById(R.id.text);
                                textView.setText("주문을 취소했습니다.");
                            }
                        })
                        .show();
            }
        });
    }
}