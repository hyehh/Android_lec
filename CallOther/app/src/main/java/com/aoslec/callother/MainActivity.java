package com.aoslec.callother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.web).setOnClickListener(mClickListener);
        findViewById(R.id.dial).setOnClickListener(mClickListener);
        findViewById(R.id.list).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.web:
                    // 명시적 intent
                    // 안드로이드 핸드폰 사면 기본적으로 웹이나 전화는 들어가있는 기능이기에 Intent.~ 이거 사용가능
                    // 그래서 start시점이 없고, Intent.ACTION_VIEW 임!
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    startActivity(intent);
                    break;
                case R.id.dial:
                    // tel:~ 이렇게 써줘야 함!
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
                    startActivity(intent);
                    break;
                case R.id.list:
                    // 우리가 만든 앱 중에 하나 선택 가능 (다른 사람이 만든 건 안됨)
                    // 우리가 만든건 정보가 있고 다른 사람이 만든 건 정보가 없기 때문
                    intent = new Intent(Intent.ACTION_MAIN);
                    // 클릭하면 구동 될 패키지 이름 & 클라스 이름을 알아야 함
                    intent.setComponent(new ComponentName("com.aoslec.listadddelete", "com.aoslec.listadddelete.MainActivity"));
                    startActivity(intent);
                    break;
            }
        }
    };
}