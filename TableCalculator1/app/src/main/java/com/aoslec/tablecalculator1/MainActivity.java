package com.aoslec.tablecalculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    Integer num1, num2;
    String result;

    // 10개의 숫자 버튼 배열
    Button[] numButtons = new Button[10];
    // 10개 숫자 버튼의 id 값 배열
    Integer[] numBtnIDs = {R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기");
        edit1 = findViewById(R.id.num1);
        edit2 = findViewById(R.id.num2);

        btnAdd = findViewById(R.id.btnPlus);
        btnSub = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        textResult = findViewById(R.id.calresult);

        btnAdd.setOnClickListener(mClickListener);
        btnSub.setOnClickListener(mClickListener);
        btnMul.setOnClickListener(mClickListener);
        btnDiv.setOnClickListener(mClickListener);

        // 숫자 버튼 10개를 대입
        for(int i=0; i<numBtnIDs.length; i++){
            numButtons[i] = findViewById(numBtnIDs[i]);
        }

        // 숫자 버튼 10개에 대해서 클릭 이벤트 처리
        for(int i=0; i<numBtnIDs.length; i++){
//            final int index; // 버튼 번호임 (바뀌면 안되니까 final 로 줌
//            index = i;
            final int index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 포커스가 되어 있는 에디트 텍스트에 숫자 추가
                    if(edit1.isFocused() == true){
                        // 전에 있던 것  + 버튼 값
                        num1 = Integer.parseInt(edit1.getText().toString() + numButtons[index].getText().toString());
                        edit1.setText(Integer.toString(num1));
                    }else if(edit2.isFocused() == true){
                        num2 = Integer.parseInt(edit2.getText().toString() + numButtons[index].getText().toString());
                        edit2.setText(Integer.toString(num2));
                    }else{
                        // 숫자1 입력 이나 숫자2 입력 을 누르지 않고 숫자를 누른 경우
                        Toast.makeText(MainActivity.this, "입력 항목부터 선택하세요!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } // for문 종료 ------
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num1 = Integer.parseInt(edit1.getText().toString());
            num2 = Integer.parseInt(edit2.getText().toString());

            switch (v.getId()){
                case R.id.btnPlus:
                    if(edit1.getText().toString().equals("") || edit2.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "값을 먼저 입력해주세요!", Toast.LENGTH_SHORT).show();
                        break;
                    }else {
                        result = Integer.toString(num1 + num2);
                        break;
                    }
                case R.id.btnMinus:
                    result = Integer.toString(num1 - num2);
                    break;
                case R.id.btnMul:
                    result = Integer.toString(num1 * num2);
                    break;
                case R.id.btnDiv:
                    result = Double.toString(num1 / (double)num2);
                    break;
            }
            textResult.setText("계산결과 : " + result);
        }
    };
}