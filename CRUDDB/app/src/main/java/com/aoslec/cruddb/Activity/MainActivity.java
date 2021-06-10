package com.aoslec.cruddb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aoslec.cruddb.R;

public class MainActivity extends AppCompatActivity {

    EditText editIP;
    Button insertBtn, updateBtn, deleteBtn, selectAllBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListener();
    }

    private void addListener(){
        editIP = findViewById(R.id.edit_ip);
        insertBtn = findViewById(R.id.btn_insert);
        updateBtn = findViewById(R.id.btn_update);
        deleteBtn = findViewById(R.id.btn_delete);
        selectAllBtn = findViewById(R.id.btn_selectA);

        insertBtn.setOnClickListener(onClickListener);
        updateBtn.setOnClickListener(onClickListener);
        deleteBtn.setOnClickListener(onClickListener);
        selectAllBtn.setOnClickListener(onClickListener);
    } // ------ addListener

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tempIp = editIP.getText().toString();
            // tempIp를 intent로 넘겨줘야 함
            Intent intent = null;

            switch (v.getId()){
                case R.id.btn_insert:
                    intent = new Intent(MainActivity.this, InsertActivity.class);
                    intent.putExtra("macIP", tempIp);
                    startActivity(intent);
                    break;
                case R.id.btn_update:
                    Toast.makeText(MainActivity.this, "검색 후 선택을 짧게 누르면 수정 화면으로 이동합니다!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_delete:
                    Toast.makeText(MainActivity.this, "검색 후 선택을 길게 누르면 삭제 화면으로 이동합니다!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_selectA:
                    intent = new Intent(MainActivity.this, SelectAllActivity.class);
                    intent.putExtra("macIP", tempIp);
                    startActivity(intent);
                    break;
            }
        }
    };
} // ------ MainActivity