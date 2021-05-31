package com.aoslec.buttonedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        edit = findViewById(R.id.edit);

        // new View.OnClickListener() button.OnclickListener 로 써도 상관 없음 (근데 view가 최상위이기 때문에 이렇게 적어도 되는 것임)
        // button.setOnClickListener(new Button.onClickListener());
        // 근데 이렇게 하면 내가 Button.onClickListener() 직접 만들어주어야 함!
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // edit의 텍스트를 가져와서 string으로 바꾼 후 str에 저장하겠다
                String str = edit.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

    }
}