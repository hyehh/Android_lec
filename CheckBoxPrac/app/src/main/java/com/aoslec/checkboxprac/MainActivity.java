package com.aoslec.checkboxprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 4개의 체크 버튼 배열
    CheckBox[] checks;
    // 4개의 체크 버튼 id 값 배열
    Integer[] intArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checks  = new CheckBox[4];
        intArr = new Integer[]{R.id.cb_01, R.id.cb_02, R.id.cb_03, R.id.cb_04};

        for(int i=0; i<checks.length; i++){
            checks[i] = findViewById(intArr[i]);
            checks[i].setOnCheckedChangeListener(checkListener);
        }
    }

    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String str = "";
            String[] arr = {"운동", "요리", "독서", "여행"};

            for(int i=0; i<4; i++){
                if(checks[i].isChecked()==false){
                    arr[i] = "";
                }
            }

            for(int i=0; i<arr.length; i++){
                str += arr[i];
            }

            if(arr[0] == "" & arr[1] == "" && arr[2] == "" && arr[3] == ""){
                Toast.makeText(MainActivity.this,"아무것도 선택하지 않았습니다!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this,str + "is Checked!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}