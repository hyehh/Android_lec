package com.aoslec.tablecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, mul, div;
    TextView calresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        mul = findViewById(R.id.btnMul);
        div = findViewById(R.id.btnDiv);
        calresult = findViewById(R.id.calresult);

//        if(num1.getText().toString().equals("") || num2.getText().toString().equals("")){
//            plus.setOnClickListener(empty);
//            minus.setOnClickListener(empty);
//            mul.setOnClickListener(empty);
//            div.setOnClickListener(empty);
//        }else{
            plus.setOnClickListener(onClickListener);
            minus.setOnClickListener(onClickListener);
            mul.setOnClickListener(onClickListener);
            div.setOnClickListener(onClickListener);
//        }


//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int firstnum = Integer.parseInt(num1.getText().toString());
//                int secondnum = Integer.parseInt(num2.getText().toString());
//                int result = firstnum + secondnum;
//                calresult.setText("계산 결과 : " + Integer.toString(result));
//            }
//        });

        num1.isFocused();


    }

    View.OnClickListener empty = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnPlus:
                    break;
                case R.id.btnMinus:
                    break;
                case R.id.btnMul:
                    break;
                case R.id.btnDiv:
                    break;
            }
            Toast.makeText(MainActivity.this, "값을 먼저 입력해주세요!", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int firstnum = Integer.parseInt(num1.getText().toString());
            int secondnum = Integer.parseInt(num2.getText().toString());
            double result = 0;
            switch (v.getId()){
                case R.id.btnPlus:
                    if(num1.getText().toString().equals("") || num2.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "값을 먼저 입력해주세요!", Toast.LENGTH_SHORT).show();
                    }else{
                        result = firstnum + secondnum;
                    }
                    break;
                case R.id.btnMinus:
                    result = firstnum - secondnum;
                    break;
                case R.id.btnMul:
                    result = firstnum * secondnum;
                    break;
                case R.id.btnDiv:
                    result = (double)firstnum / (double)secondnum;
                    break;
            }
            calresult.setText("계산 결과 : " + Double.toString(result));
        }
    };
}