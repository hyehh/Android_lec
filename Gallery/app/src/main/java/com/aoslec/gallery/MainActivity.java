package com.aoslec.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("갤러리 영화 포스터");

        Gallery gallery = findViewById(R.id.gallery1);
        MyGalleryAdapter adapter = new MyGalleryAdapter(MainActivity.this);
//        MyGalleryAdapter adapter = new MyGalleryAdapter(this); 둘 다 가능
        gallery.setAdapter(adapter);
    }

    public class MyGalleryAdapter extends BaseAdapter{

        // Field
        Context context;
        int[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
        };

        //Constructor
        public MyGalleryAdapter(Context context) {
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
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]);

            // dialog 말고 listner 사용
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPostr = findViewById(R.id.ivPoster);
                    ivPostr.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPostr.setImageResource(posterID[position]);

                    //return true 하면 끝에만 잡아야 움직임 (터치값을 true로 하면 움직이기가 힘들어짐 -> false로 하는 게 자연스럽게 움직여짐)
                    return false;
                }
            });

            return imageView;
        }
    }
}