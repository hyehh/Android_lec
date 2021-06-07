package com.aoslec.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ToolBarFragment.ToolbarListener{
    // ToolBarFragment의 ToolbarListener 인터페이스 실행한다!
    // 이렇게 되면 ToolbarListener 실행 후, onCreate 한다!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "onCreate_main");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonClick(int position, String text) {
        Log.v("Message", "onButtonClick_main");
        // getSupportFragmentManager는 intent 같은 느낌!
        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_2);
        // changeTextProperties 여기에 값 주기
        textFragment.changeTextProperties(position, text);
    }
}