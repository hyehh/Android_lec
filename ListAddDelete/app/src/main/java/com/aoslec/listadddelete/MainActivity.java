package com.aoslec.listadddelete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        // 이미 있는 ArrayAdapter 사용하는 것임!
        // 기본적으로 가져오는 게 있는데 simple_list_item_single_choice 이거는 추가로 가져오는 것이기 때문에 android라고 추가적으로 써서 가져와야 함!
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);

        list = findViewById(R.id.list);
        list.setAdapter(adapter);
        // CHOICE_MODE_SINGLE 이게 라디오 버튼! 선택할 수 있게 그림 그려준 것
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // 클릭하는 건 아래꺼! 꾹 눌러야 하는 건 long~ 이라고 따로 있음!
        list.setOnItemClickListener(mItemClickListener);

        findViewById(R.id.add).setOnClickListener(mClickListener);
        findViewById(R.id.delete).setOnClickListener(mClickListener);

    } // onCreate

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String message;
            message = "Select Item = " + items.get(position);
            // 지금은 onCreate 밖에 있어서 MainActivity.this 라고 알려줘야 함! this라고 쓰면 어디인지 알 수가 없음! (this는 onCreate 안에 있어야 함)
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText editText = findViewById(R.id.newItem);
            switch (v.getId()){
                case R.id.add:
                    String text = editText.getText().toString();
                    if(text.length()!=0){
                        items.add(text);
                        editText.setText("");
                        // 어댑터에 알려주면 자동으로 어댑터 데이터가 바뀜
                        adapter.notifyDataSetChanged();
                    }
                    break;
                case R.id.delete:
                    int id;
                    // 무엇을 눌렀는지 알아야 하기 때문
                    id = list.getCheckedItemPosition();
                    // listview에서 이상한 거 누른 게 아니면 해당 if문 실행
                    if(id != ListView.INVALID_POSITION){
                        items.remove(id);
                        // 전에 체크된 걸 기억하는 걸 지워버리는 것
                        list.clearChoices();
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };
}