package com.aoslec.customadapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Weater> data = null;
    private WeatherAdapter adapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data 만들기
        data = new ArrayList<Weater>();
        data.add(new Weater("월", R.drawable.w1, "맑음"));
        data.add(new Weater("화", R.drawable.w2, "비"));
        data.add(new Weater("수", R.drawable.w3, "맑음뒤비"));
        data.add(new Weater("목", R.drawable.w4, "추움"));
        data.add(new Weater("금", R.drawable.w5, "쾌청"));
        data.add(new Weater("토", R.drawable.w6, "눈"));
        data.add(new Weater("일", R.drawable.w7, "우박"));
        data.add(new Weater("월", R.drawable.w1, "맑음"));
        data.add(new Weater("화", R.drawable.w2, "비"));
        data.add(new Weater("수", R.drawable.w3, "맑음뒤비"));
        data.add(new Weater("목", R.drawable.w4, "추움"));
        data.add(new Weater("금", R.drawable.w5, "쾌청"));
        data.add(new Weater("토", R.drawable.w6, "눈"));
        data.add(new Weater("일", R.drawable.w7, "우박"));
        data.add(new Weater("월", R.drawable.w1, "맑음"));
        data.add(new Weater("화", R.drawable.w2, "비"));
        data.add(new Weater("수", R.drawable.w3, "맑음뒤비"));
        data.add(new Weater("목", R.drawable.w4, "추움"));
        data.add(new Weater("금", R.drawable.w5, "쾌청"));
        data.add(new Weater("토", R.drawable.w6, "눈"));
        data.add(new Weater("일", R.drawable.w7, "우박"));

        // Adapter 연결하기
        adapter = new WeatherAdapter(MainActivity.this, R.layout.custom_layout_xml, data);

        // ListView
        listView = findViewById(R.id.lv_weather);
        listView.setAdapter(adapter);
    }
}