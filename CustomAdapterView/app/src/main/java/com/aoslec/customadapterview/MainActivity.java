package com.aoslec.customadapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 이렇게 쓰면 앱 바가 안보임!! AppCompat 삭제하면 됨
//public class MainActivity extends Activity {

    private ArrayList<Weater> data = null;
    private WeatherAdapter adapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 처음에 activity 메인을 띄운다! (아직 listview에 데이터 없음)
        setContentView(R.layout.activity_main);

        // Data 만들기
        // <>String 주면 String 하나 밖에 못들어가기 때문에 Weater 라는 bean을 만들어줌
        data = new ArrayList<Weater>();

//        이렇게 두 줄 쓰기 싫어서 밑에 처럼 하나로 작성 (원래는 이게 정석인데 너무 많으면 코드 복잡하기에 한 줄로 합침)
//        Weater weater = new Weater("월", R.drawable.w1, "맑음");
//        data.add(weater);

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