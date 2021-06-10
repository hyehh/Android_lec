package com.aoslec.cruddb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aoslec.cruddb.NetworkTask.NetworkTask;
import com.aoslec.cruddb.R;

public class InsertActivity extends AppCompatActivity {
    // adapter 필요없고 networktask 필요 (입력할 때는 adapter 필요 없음)

    String urlAddr = null;
    String scode, sname, sdept, sphone, macIP;
    EditText ecode, ename, edept, ephone;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        // 맨 뒤에 ? 잊지 말기! (get방식으로 날리기 위해 필요)
        urlAddr = "http://" + macIP + ":8080/test/studentInsertReturn.jsp?";

        ecode = findViewById(R.id.insert_code);
        ename = findViewById(R.id.insert_name);
        edept = findViewById(R.id.insert_dept);
        ephone = findViewById(R.id.insert_phone);

        // 입력시 자릿수 제한
        ecode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        ename.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        edept.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ephone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        btnInsert = findViewById(R.id.insert_btn);
        btnInsert.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            scode = ecode.getText().toString();
            sname = ename.getText().toString();
            sdept = edept.getText().toString();
            sphone = ephone.getText().toString();

            urlAddr = urlAddr + "code=" + scode + "&name=" + sname + "&dept=" + sdept + "&phone=" + sphone;

            // return 값 주는 걸로 입력이 잘됐다 안됐다를 선별할 것
            String result = connectInsertData();
            if (result.equals("1")){
                Toast.makeText(InsertActivity.this, scode + "가 입력되었습니다", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(InsertActivity.this, "입력이 실패 되었습니다", Toast.LENGTH_SHORT).show();
            }
            // finish하면 메인화면으로 이동함! (전화면으로 이동하는 것임 - insert화면은 없어짐)
            finish();
        }
    };

    private String connectInsertData(){
        String result = null;
        try {
            // NetworkTask 로 넘겨줌
            NetworkTask networkTask = new NetworkTask(InsertActivity.this, urlAddr, "insert");
            Object obj = networkTask.execute().get();
            // 1이 들어오면 성공한 것, 만약 그 이외의 숫자면 실패한 것
            result = (String) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}