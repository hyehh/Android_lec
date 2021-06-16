package com.aoslec.chiptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

//    Chip chip1, chip2, chip3;
    ChipGroup chipGroup;
    Button button, nextBtn;
    String urlAddr;
    String macIP = "192.168.0.128";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        chip1 = (Chip) findViewById(R.id.chip1);
//        chip2 = (Chip) findViewById(R.id.chip2);
//        chip3 = (Chip) findViewById(R.id.chip3);
        button = findViewById(R.id.click_btn);
        nextBtn = findViewById(R.id.next_btn);
        chipGroup = (ChipGroup) findViewById(R.id.chip_group);
//        chipGroup.addView(chip1);
//        chipGroup.addView(chip2);
//        chipGroup.addView(chip3);



//        chip2.setText("이제 되라");

//        chip1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(MainActivity.this, "chip1 clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, SelectActivity.class);
                intent.putExtra("macIP", macIP);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringBuilder result = new StringBuilder("");
                for(int i=0; i<chipGroup.getChildCount(); i++) {
                    Chip chip = (Chip) chipGroup.getChildAt(i);
                    if (chip.isChecked())
                        if (i < chipGroup.getChildCount()-1) result.append(chip.getText()).append(",");
                        else result.append(chip.getText());

                }
                    Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();

                urlAddr = "http://" + macIP + ":8080/test/chipInsert.jsp?" + "chip=" + result.toString();
                Log.v("Message", urlAddr);

                String result2 = connectInsertData();
                Log.v("Message", result2);
                if(result2.equals("1")){
                    Toast.makeText(MainActivity.this, "입력이 성공 되었습니다", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "입력이 실패 되었습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String connectInsertData(){
        Log.v("Message", "result");
        String result = null;
        try {
            Log.v("Message", "여기 오니? result");
            Log.v("Message", urlAddr);

            // NetworkTask 로 넘겨줌
            NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr, "insert");
            Object obj = networkTask.execute().get();
            // 1이 들어오면 성공한 것, 만약 그 이외의 숫자면 실패한 것
            result = (String) obj;
            Log.v("Message", result);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_SHORT).show();
        }
        return result;
    }
}