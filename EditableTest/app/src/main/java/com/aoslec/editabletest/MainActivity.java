package com.aoslec.editabletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);

        Button btn1 = findViewById(R.id.btnIns);
        btn1.setOnClickListener(mClickListener);
        // 한줄로 적을 수도 있음 -> 버튼 텍스트를 바꾸지 않는 이상 굳이 2줄 쓸 필요 없음
        findViewById(R.id.btnDel).setOnClickListener(mClickListener);
        findViewById(R.id.btnApp).setOnClickListener(mClickListener);
        findViewById(R.id.btnRep).setOnClickListener(mClickListener);
        findViewById(R.id.btnClear).setOnClickListener(mClickListener);

    } // onCreate

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 화면에 있는 글씨를 editable로 받아서 사용하면 이런 기능들을 처리할 수 있다
            Editable edit = editText.getText();
            switch (v.getId()){
                case R.id.btnIns:
                    edit.insert(0,"INS");
                    break;
                case R.id.btnDel:
                    edit.delete(2,5);
                    break;
                case R.id.btnApp:
                    edit.append("APP");
                    break;
                case R.id.btnRep:
                    edit.replace(2,5,"REP");
                    break;
                case R.id.btnClear:
                    edit.clear();
                    break;
            }
        }
    };

} // MainActivity