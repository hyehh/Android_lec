package com.aoslec.cruddb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aoslec.cruddb.Adapter.StudentAdapter;
import com.aoslec.cruddb.Bean.Student;
import com.aoslec.cruddb.NetworkTask.NetworkTask;
import com.aoslec.cruddb.R;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    // 우리가 만들어줄 address
    String urlAddr = null;
    ArrayList<Student> students = null;
    StudentAdapter adapter = null;
    ListView listView = null;
    // 가져온 address
    String macIP = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

        listView = findViewById(R.id.lv_student);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/student_query_all.jsp";
        // connectGetData(); 데이터 갱신하는 부분 onCreate에 있으면 안됨!! 왜냐면 onCreate는 한 번 뜨고 다시 작동 안하기 때문!
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 여기 있어야 데이터가 처음 실행될 때도 업데이트 되고, 수정버튼 누르고 다시 돌아왔을 때도 업데이트 된다!
        connectGetData();
    }

    private void connectGetData(){
        try {
            NetworkTask networkTask = new NetworkTask(SelectAllActivity.this, urlAddr, "select");
            Object obj = networkTask.execute().get();
            students = (ArrayList<Student>) obj;
            // NetworkTask 일 끝남

            // 이제 adapter 일 시작
            adapter = new StudentAdapter(SelectAllActivity.this, R.layout.student_layout, students);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(onItemClickListener);
            listView.setOnItemLongClickListener(onItemLongClickListener);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        Intent intent = null;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code", students.get(position).getCode());
            intent.putExtra("name", students.get(position).getName());
            intent.putExtra("dept", students.get(position).getDept());
            intent.putExtra("phone", students.get(position).getPhone());
            intent.putExtra("macIP", macIP);
            startActivity(intent);
        }
    };

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        Intent intent = null;
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, DeleteActivity.class);
            intent.putExtra("code", students.get(position).getCode());
            intent.putExtra("name", students.get(position).getName());
            intent.putExtra("dept", students.get(position).getDept());
            intent.putExtra("phone", students.get(position).getPhone());
            intent.putExtra("macIP", macIP);
            startActivity(intent);
            return true;
        }
    };

}