package com.aoslec.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    // 데이터를 배열로 받겠다는 의미
    private int[] data;

    public CustomAdapter(Context mContext, int[] data) {
        // Main에 mContext를 올리는 것
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
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
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100,100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        }else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(data[position]);

        // 이미지 크게 보여주기
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = View.inflate(mContext, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(mContext);
                ImageView ivDialog = dialogView.findViewById(R.id.ivDialog);
                ivDialog.setImageResource(data[position]);

                dlg.setTitle(" >>> 날씨 <<< ");
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

        // return 값 view로 바꿔줘야 함!!!!!
        return imageView;
    }
}
