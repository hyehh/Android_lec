package com.aoslec.bottomsheetdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BottomSheet bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "onCreate_Main");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Message", "onClick_Main");
                bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }
}