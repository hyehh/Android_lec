package com.aoslec.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK = findViewById(R.id.button);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Snackbar를 눌렀습니다", Snackbar.LENGTH_SHORT).show();
//                Snackbar.make(MainActivity.this,"Snackbar를 눌렀습니다", Snackbar.LENGTH_SHORT).show();
//                이거 쓰면 안됨! 왜냐면 view를 쓰는 부분이기 때문
            }
        });
    } // onCreate
} // MainActivity