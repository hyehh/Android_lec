package com.aoslec.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnUpdate, btnDelete, btnSelect;
    TextView tvResult;
    MemberInfo memberInfo; // 우리가 만든 클라스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberInfo = new MemberInfo(MainActivity.this);

        btnInsert = findViewById(R.id.btn_insert);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);
        btnSelect = findViewById(R.id.btn_select);
        tvResult = findViewById(R.id.tv_result);

        btnInsert.setOnClickListener(onClickListener);
        btnUpdate.setOnClickListener(onClickListener);
        btnDelete.setOnClickListener(onClickListener);
        btnSelect.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        // DB 이름 설정
        SQLiteDatabase DB;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_insert:
                    try {
                        // 권한을 줘야함
                        DB = memberInfo.getWritableDatabase();
                        String query = "INSERT INTO member(username, userid, passwd) VALUES ('홍길동', 'hkdong', 1111);";
                        DB.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Insert OK", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Insert Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_update:
                    try {
                        // 권한을 줘야함
                        DB = memberInfo.getWritableDatabase();
                        String query = "UPDATE member SET username = '임꺽정' WHERE userid = 'hkdong';";
                        DB.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Update OK", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Update Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_delete:
                    try {
                        // 권한을 줘야함
                        DB = memberInfo.getWritableDatabase();
                        String query = "DELETE FROM member;";
                        DB.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Delete OK", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Delete Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_select:
                    try {
                        // 이거는 가져오는 것이기 때문에 writable 아니고 readable
                        DB = memberInfo.getReadableDatabase();
                        String query = "SELECT username, userid, passwd FROM member;";
                        // 위치를 알고 있는 게 Cursor
                        Cursor cursor = DB.rawQuery(query, null);
                        // stringBuffer는 string에 문제가 있어서 새롭게 나온 게 stringBuffer (arraylist라고 생각하기)
                        StringBuffer stringBuffer = new StringBuffer();
                        // resultset.next()와 같다고 생각하기
                        // 다음에 읽어올 것이 있으면 읽고 아니면 빠진다
                        while (cursor.moveToNext()){
                            // data 가져오기
                            String username = cursor.getString(0);
                            String userid = cursor.getString(1);
                            int passwd = cursor.getInt(2);
                            // 가져온 걸 stringbuffer에 넣기
                            stringBuffer.append("username : " + username + ", userid : " + userid + ", passwd : " + passwd + "\n");
                        }
                        tvResult.setText(stringBuffer.toString());
                        cursor.close();
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Select OK", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Select Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
}