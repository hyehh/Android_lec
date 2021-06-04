package com.aoslec.intentidpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, pw;
    Button mainBtn;
    String userId, userPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.userId);
        pw = findViewById(R.id.password);
        mainBtn = findViewById(R.id.btnMain);

        mainBtn.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userId = id.getText().toString();
            userPw = pw.getText().toString();

            if(userId.equals("aaa") && userPw.equals("1111")){
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
                id.setText("");
                pw.setText("");
            }else {
                Toast.makeText(MainActivity.this, "ID나 Password가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
            }

        }
    };
}