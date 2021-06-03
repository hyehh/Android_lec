package com.aoslec.fruitprac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnApple, btnOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);
        btnApple = findViewById(R.id.btnApple);
        btnOrange = findViewById(R.id.btnOrange);

        btnApple.setOnClickListener(onClickListener);
        btnOrange.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnApple:
                    textView.setText("APPLE");
                    textView.setTextColor(Color.RED);
                    btnApple.setBackgroundColor(Color.RED);
                    btnOrange.setBackgroundColor(0xBCB9B9);
                    break;
                case R.id.btnOrange:
                    textView.setText("ORANGE");
                    textView.setTextColor(0x50ff0000);
                    btnOrange.setBackgroundColor(0x50ff0000);
                    btnApple.setBackgroundColor(0xBCB9B9);
                    break;
            }
        }
    };
}