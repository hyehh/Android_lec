package com.aoslec.imagedownload;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    final static String TAG = "MainActivity";
    String urlAddr = "http://192.168.0.128:8080/test/cat.PNG";
    Button button;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        button.setOnClickListener(onClickListener);
        imageView = findViewById(R.id.imageView);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn:
                    NetworkTask networkTask = new NetworkTask(MainActivity.this, imageView, urlAddr);
                    networkTask.execute(100);
                    button.setText("Download Completely!");
                    break;
            }
        }
    };

}