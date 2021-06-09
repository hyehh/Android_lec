package com.aoslec.networkjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://192.168.0.128:8080/test/json_members.json";
    Button button;
    ListView listView;
    ArrayList<JsonMember> members;
    MemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);
        listView = findViewById(R.id.lv);

        // 참고 NetworkTask : 데이터 불러오는 애 / MemberAdapter : 데이터 얹혀주는 애

        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_network_con:
                    try {
                        NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                        // object 가 return값
                        // networkTask.execute().get() 하면 한꺼번에 실행(뺑뺑이 돌고 데이터 보내주고)됨! 그래서 메소드 하나씩 적을 수 없기에 get()이라고 적어야 함
                        // 그래서 리턴값을 하나로 정의하기 힘들어서 object로 정의한 것임
                        Object obj = networkTask.execute().get();
                        // 이제 obj에 데이터가 들어가있을 것임 -> 이걸 arraylist로 바꿔야함
                        members = (ArrayList<JsonMember>) obj;
                        // 이제 데이터 세팅끝!

                        // 이제 화면에 보여줘야 함 -> 이 때 등장하는 게 어댑터
                        adapter = new MemberAdapter(MainActivity.this, R.layout.custom_layout, members);
                        listView.setAdapter(adapter);
                        button.setText("Results");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
}