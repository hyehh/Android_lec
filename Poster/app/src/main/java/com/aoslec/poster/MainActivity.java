package com.aoslec.poster;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그리드뷰 영화 포스터");
        GridView gv = findViewById(R.id.gridView1);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv.setAdapter(gridAdapter);

    }

    // class 새로 만드는 게 좋음! main에 여러개 클라스 만드는 거 지양! (지금은 코드 한 눈에 보여주기 위함)
    public class MyGridAdapter extends BaseAdapter{

        Context context;
        // 데이터를 여기서 만들어버림
        int[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
                };

        // 위에서 데이터를 만들어버렸기 때문에 생성자는 data 없이 context 만 만들면 됨!
        public MyGridAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if 안쓰고 해봄 (안써도 됨)
            // context(화면)에다가 이미지를 저장한다는 의미
            ImageView imageView = new ImageView(context);
            // 사진 크기 조절
            imageView.setLayoutParams(new GridView.LayoutParams(200,300));
            // gravity 같은 느낌
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            // 데이터 300개 있으면 300번 돈다!
            imageView.setImageResource(posterID[position]);

            // 이미지 크게 보여주기
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // dialog.xml에 그림을 올리려면 inflate를 만들어야 함!
                    View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    // 다이얼로그를 MainActivity.this에 만들겠다고 위치 지정
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    // 새로 만든 xml에는 tools:context=".MainActivity" 이게 없기 때문에 dialogView. 이런 거 추가해야 함
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                    // 선택한 position의 값의 이미지를 보여준다는 의미
                    ivPoster.setImageResource(posterID[position]);

                    dlg.setTitle(" >>> 포스터 <<< ");
                    dlg.setView(dialogView);
                    // 클릭했을 때 다른 것과 연결하고 싶으면 null 말고 listner 주면 됨!
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }
}