package com.aoslec.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearFirst, linearSecond, linearThird, linearFourth, result01, result02, result03, result04;
    Button mainBtn, secondBtn, thirdBtn, fourthBtn, resetBtn1, resetBtn2, resetBtn3, resetBtn4;
    EditText height, weight;
    TextView tv_bmi, tv_result;

    double cm, kg, calResult;
    String result, range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearFirst = findViewById(R.id.firstLinear);
        linearSecond = findViewById(R.id.secondLinear);
        linearThird = findViewById(R.id.thirdLinear);
        linearFourth = findViewById(R.id.fourthLinear);
        result01 = findViewById(R.id.ll_result_01);
        result02 = findViewById(R.id.ll_result_02);
        result03 = findViewById(R.id.ll_result_03);
        result04 = findViewById(R.id.ll_result_04);

        mainBtn = findViewById(R.id.mainBtn);
        secondBtn = findViewById(R.id.SecondBtn);
        thirdBtn = findViewById(R.id.ThirdBtn);
        fourthBtn = findViewById(R.id.FourthBtn);
        resetBtn1 = findViewById(R.id.resetBtn1);
        resetBtn2 = findViewById(R.id.resetBtn2);
        resetBtn3 = findViewById(R.id.resetBtn3);
        resetBtn4 = findViewById(R.id.resetBtn4);

        height = findViewById(R.id.editHeight);
        weight = findViewById(R.id.editWeight);

        tv_bmi = findViewById(R.id.tv_bmi);
        tv_result = findViewById(R.id.tv_result);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.VISIBLE);
                linearThird.setVisibility(v.INVISIBLE);
                linearFourth.setVisibility(v.INVISIBLE);
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearFirst.setVisibility(v.INVISIBLE);
                linearSecond.setVisibility(v.INVISIBLE);
                linearThird.setVisibility(v.VISIBLE);
                linearFourth.setVisibility(v.INVISIBLE);
            }
        });

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(height.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "키를 입력한 후, 버튼을 클릭해주세요!", Toast.LENGTH_SHORT).show();
                }else if(weight.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"몸무게를 입력한 후, 버튼을 클릭해주세요!", Toast.LENGTH_SHORT).show();
                }else{
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.INVISIBLE);
                    linearFourth.setVisibility(v.VISIBLE);

                    cm = Double.parseDouble(height.getText().toString());
                    kg = Double.parseDouble(weight.getText().toString());
                    calResult = kg / (cm * 0.01 * cm * 0.01);
                    result = String.format("%.2f", calResult);

                    tv_bmi.setText(result);

                    if(Double.parseDouble(result) < 18.5){
                        range = "저체중";
                    }else if(Double.parseDouble(result) < 25){
                        range = "정상";
                    }else if(Double.parseDouble(result) < 30){
                        range = "과체중";
                    }else{
                        range = "비만";
                    }

                    tv_result.setText(range);
                }
            }
        });

        fourthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(range == "정상"){
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.INVISIBLE);
                    linearFourth.setVisibility(v.INVISIBLE);
                    result01.setVisibility(v.VISIBLE);
                    result02.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.INVISIBLE);
                    result04.setVisibility(v.INVISIBLE);
                }else if(range == "저체중"){
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.INVISIBLE);
                    linearFourth.setVisibility(v.INVISIBLE);
                    result02.setVisibility(v.VISIBLE);
                    result01.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.INVISIBLE);
                    result04.setVisibility(v.INVISIBLE);
                }else if(range == "과체중"){
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.INVISIBLE);
                    linearFourth.setVisibility(v.INVISIBLE);
                    result02.setVisibility(v.INVISIBLE);
                    result01.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.VISIBLE);
                    result04.setVisibility(v.INVISIBLE);
                }else {
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.INVISIBLE);
                    linearFourth.setVisibility(v.INVISIBLE);
                    result02.setVisibility(v.INVISIBLE);
                    result01.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.INVISIBLE);
                    result04.setVisibility(v.VISIBLE);
                }
            }
        });

        resetBtn1.setOnClickListener(onClickListener);
        resetBtn2.setOnClickListener(onClickListener);
        resetBtn3.setOnClickListener(onClickListener);
        resetBtn4.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.resetBtn1:
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.VISIBLE);
                    weight.setText("");
                    height.setText("");
                    linearFourth.setVisibility(v.INVISIBLE);
                    result02.setVisibility(v.INVISIBLE);
                    result01.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.INVISIBLE);
                    result04.setVisibility(v.INVISIBLE);
                    break;
                case R.id.resetBtn2:
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.VISIBLE);
                    weight.setText("");
                    height.setText("");
                    linearFourth.setVisibility(v.INVISIBLE);
                    result02.setVisibility(v.INVISIBLE);
                    result01.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.INVISIBLE);
                    result04.setVisibility(v.INVISIBLE);
                    break;
                case R.id.resetBtn3:
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.VISIBLE);
                    weight.setText("");
                    height.setText("");
                    linearFourth.setVisibility(v.INVISIBLE);
                    result02.setVisibility(v.INVISIBLE);
                    result01.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.INVISIBLE);
                    result04.setVisibility(v.INVISIBLE);
                    break;
                case R.id.resetBtn4:
                    linearFirst.setVisibility(v.INVISIBLE);
                    linearSecond.setVisibility(v.INVISIBLE);
                    linearThird.setVisibility(v.VISIBLE);
                    weight.setText("");
                    height.setText("");
                    linearFourth.setVisibility(v.INVISIBLE);
                    result02.setVisibility(v.INVISIBLE);
                    result01.setVisibility(v.INVISIBLE);
                    result03.setVisibility(v.INVISIBLE);
                    result04.setVisibility(v.INVISIBLE);
                    break;
            }
        }
    };
}