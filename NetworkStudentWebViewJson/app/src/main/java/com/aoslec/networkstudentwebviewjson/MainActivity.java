package com.aoslec.networkstudentwebviewjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://192.168.0.2:8080/test/pet.json";
    Button button;
    RecyclerView recyclerView = null;
    RecyclerView.LayoutManager layoutManager = null;
    RecyclerView.Adapter adapter;
    ArrayList<Pets> pets = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);
        recyclerView = findViewById(R.id.recylcerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                // networkTask의 대부분의 모든 것을 object로 받는다!
                Object obj = networkTask.execute().get();
                pets = (ArrayList<Pets>) obj;

                adapter = new PetAdapter(MainActivity.this, R.layout.card_web_view, pets);

                recyclerView.setAdapter(adapter);
                button.setText("Results");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };
}