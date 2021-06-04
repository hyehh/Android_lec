package com.aoslec.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "onCreate_Sub");
        super.onCreate(savedInstanceState);

        // 화면 회전
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_sub);

        Button btnClose = findViewById(R.id.close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이것만 적으면 바로 메인 액티비티 뜬다
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        Log.v("Message", "onStart_Sub");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message", "onResume_Sub");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message", "onPause_Sub");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message", "onStop_Sub");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message", "onDestroy_Sub");
        super.onDestroy();
    }
}