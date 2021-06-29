package com.aoslec.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2 = null;
    Button plusBtn, minusBtn, mulBtn, divBtn = null;
    TextView result = null;
    int number1, number2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("가감승제 계산기");

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);
        result = findViewById(R.id.result);

        plusBtn.setOnClickListener(onClickListener);
        minusBtn.setOnClickListener(onClickListener);
        mulBtn.setOnClickListener(onClickListener);
        divBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            if(num1.getText().toString().isEmpty()||num2.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "숫자를 먼저 입력해주세요!", Toast.LENGTH_SHORT).show();
            }else {
                number1 = Integer.parseInt(num1.getText().toString());
                number2 = Integer.parseInt(num2.getText().toString());
                switch (v.getId()){
                    case R.id.plusBtn:
                        result.setText("계산 결과 : " + (number1+number2));
                        break;
                    case R.id.minusBtn:
                        result.setText("계산 결과 : " + (number1-number2));
                        break;
                    case R.id.mulBtn:
                        result.setText("계산 결과 : " + (number1*number2));
                        break;
                    case R.id.divBtn:
                        result.setText("계산 결과 : " + ((double)number1/(double)number2));
                        break;

                }

            }
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mInputMethodManager.hideSoftInputFromWindow(num2.getWindowToken(), 0);
        }
    };
}