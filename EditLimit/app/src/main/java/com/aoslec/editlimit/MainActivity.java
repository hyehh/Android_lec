package com.aoslec.editlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // 3글자 제한하기 (한글도 3글자, 영어도 3글자)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.limit);

        editText.setFilters(new InputFilter[]{
                // ; 적으면 안됨
                new InputFilter.LengthFilter(3)
        });
    }
}