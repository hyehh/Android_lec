package com.aoslec.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_01);
        cb2 = findViewById(R.id.cb_02);
        cb3 = findViewById(R.id.cb_03);
        cb4 = findViewById(R.id.cb_04);

        cb1.setOnCheckedChangeListener(checkedChangeListener);
        cb2.setOnCheckedChangeListener(checkedChangeListener);
        cb3.setOnCheckedChangeListener(checkedChangeListener);
        cb4.setOnCheckedChangeListener(checkedChangeListener);

    } // onCreate

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        // onCheckedChanged 에 넣으면 휘발성이기 때문에 값을 기억 못함! 그래서 그 위에 전역변수로 써줘야함!
        ArrayList<String> arrayList = new ArrayList<String>();

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String str = ""; // 화면에 toast로 보여주기 위한 string (글자 합할 것임)
//            String str1 = "운동";
//            String str2 = "요리";
//            String str3 = "독서";
//            String str4 = "여행";
//            arrayList.add("운동"); // 이게 0번째 인덱스
//            arrayList.add("요리"); // 이게 1번째 인덱스
//            arrayList.add("독서"); // 이게 2번째 인덱스
//            arrayList.add("여행"); // 이게 3번째 인덱스

            if(buttonView.getId() == R.id.cb_01){
                if(isChecked==true){
                    arrayList.add("운동");
                }else {
                    arrayList.remove("운동");
                }
            }

            if(buttonView.getId() == R.id.cb_02){
                if(isChecked==true){
                    arrayList.add("요리");
                }else {
                    arrayList.remove("요리");
                }
            }

            if(buttonView.getId() == R.id.cb_03){
                if(isChecked==true){
                    arrayList.add("독서");
                }else {
                    arrayList.remove("독서");
                }
            }

            if(buttonView.getId() == R.id.cb_04){
                if(isChecked==true){
                    arrayList.add("여행");
                }else {
                    arrayList.remove("여행");
                }
            }

//            if(cb2.isChecked() == true){
//                arrayList.add("요리");
//            }else {
//                arrayList.remove("요리");
//            }
//
//            if(cb3.isChecked() == true){
//                arrayList.add("독서");
//            }else {
//                arrayList.remove("독서");
//            }
//
//            if(cb4.isChecked() == true){
//                arrayList.add("여행");
//            }else {
//                arrayList.remove("여행");
//            }

            for(int i=0; i<arrayList.size(); i++){
                str = str + arrayList.get(i);
            }

            // v.getId() c처럼 CompoundButton buttonView 여기서 가져온 buttonView 사용하면 됨!
//            switch (buttonView.getId()){
//                case R.id.cb_01:
//                    if(isChecked == true){
//                        str += "운동";
//                        break;
//                    }
//                case R.id.cb_02:
//                    if(isChecked == true){
//                        str += "요리";
//                        break;
//                    }
//                case R.id.cb_03:
//                    if(isChecked == true){
//                        str += "독서";
//                        break;
//                    }
//                case R.id.cb_04:
//                    if(isChecked == true){
//                        str += "여행";
//                        break;
//                    }
//            } // switch
//            arr.length == 0
            if(arrayList.isEmpty()){
                Toast.makeText(MainActivity.this,"아무것도 선택하지 않았습니다.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,str + "is Checked.", Toast.LENGTH_SHORT).show();
            }
        }
    };

//    String str = ""; // 화면에 toast로 보여주기 위한 string (글자 합할 것임)
//            String[] arr = {"운동 ", "요리 ", "독서 ", "여행 "};
//            if(cb1.isChecked() == false){
//                    arr[0] = "";
//            }
//
//            if(cb2.isChecked() == false){
//                    arr[1] = "";
//            }
//
//            if(cb3.isChecked() == false){
//                    arr[2] = "";
//            }
//
//            if(cb4.isChecked() == false){
//                    arr[3] = "";
//            }
//
//            for(int i=0; i<arr.length; i++){
//                str += arr[i];
//            }
//
//            // v.getId() c처럼 CompoundButton buttonView 여기서 가져온 buttonView 사용하면 됨!
////            switch (buttonView.getId()){
////                case R.id.cb_01:
////                    if(isChecked == true){
////                        str += "운동";
////                        break;
////                    }
////                case R.id.cb_02:
////                    if(isChecked == true){
////                        str += "요리";
////                        break;
////                    }
////                case R.id.cb_03:
////                    if(isChecked == true){
////                        str += "독서";
////                        break;
////                    }
////                case R.id.cb_04:
////                    if(isChecked == true){
////                        str += "여행";
////                        break;
////                    }
////            } // switch
////            arr.length == 0
//            if(arr[0] == "" && arr[1] == "" && arr[2] == "" && arr[3] == ""){
//                Toast.makeText(MainActivity.this,"아무것도 선택하지 않았습니다.", Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(MainActivity.this,str + "is Checked.", Toast.LENGTH_SHORT).show();
//            }
//        }
//    };

} // MainActivity