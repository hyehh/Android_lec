package com.aoslec.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    // 데이터를 배열로 받겠다는 의미
    private int[] data;

    public CustomAdapter(Context mContext, int[] data) {
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

        // return 값 view로 바꿔줘야 함!!!!!
        return imageView;
    }
}
