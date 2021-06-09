package com.aoslec.networkstudentjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://192.168.0.128:8080/test/students.json";
    Button button;
    ArrayList<Students> students;
    StudentAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);
        listView = findViewById(R.id.lv_network_con);

        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                // networkTask의 대부분의 모든 것을 object로 받는다!
                Object obj = networkTask.execute().get();
                students = (ArrayList<Students>) obj;

                adapter = new StudentAdapter(MainActivity.this, R.layout.custom_layout, students);

                listView.setAdapter(adapter);
                button.setText("Results");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    };
}