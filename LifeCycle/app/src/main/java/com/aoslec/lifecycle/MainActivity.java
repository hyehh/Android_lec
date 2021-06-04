package com.aoslec.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 기본적으로 onCreate만 가지고 있음
        // 화면 띄우기 전 무슨 상태인지 알아보는 command => log (syso 으로 생각하기)
        // 개발할 때만 쓰고 앱 등록 시에는 삭제해야함 (그렇지 않으면 앱스토어에서 허락 안해줌)
        Log.v("Message", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.v("Message", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message", "onDestroy");
        super.onDestroy();
    }
}