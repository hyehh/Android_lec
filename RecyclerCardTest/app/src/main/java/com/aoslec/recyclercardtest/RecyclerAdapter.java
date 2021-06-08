package com.aoslec.recyclercardtest;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> { // 만들어 준 걸 하나씩 넣어주는 게 어댑터

    // 데이터 준비
    // 타이틀, 세부내용, 사진에 들어갈 배열 만들기
    private String[] titles = {"Monday 월", "Tuesday 화", "Wednesday 수", "Thursday 목", "Friday 금", "Saturday 토", "Sunday 일"};
    private String[] details = {"월요일 기상정보", "화요일 기상정보", "수요일 기상정보", "목요일 기상정보", "금요일 기상정보", "토요일 기상정보", "일요일 기상정보"};
    private int[] images = {R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4, R.drawable.w5, R.drawable.w6, R.drawable.w7};

    // 클라스 안에 클라스가 들어가있는 형태임
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        // View의 하나의 셀 세팅해주는 메소드 (이건 세팅)
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v("Message", "onClick_r");
                    // ViewHolder에서는 AdapterPosition 사용
                    int position = getAdapterPosition();
                    // setAction은 snackbar에 버튼이 있을 경우 생기는 것임
                    Snackbar.make(v, details[position], Snackbar.LENGTH_LONG).setAction("", null).show();
                }
            });
        }
    }

    // 뷰 만들어 주는 메소드 - 초기값 만들어주는 것 (이건 만듬)
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("Message", "onCreateViewHolder_r");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // view 재사용 (새로운 뷰에 데이터 넣어줌)
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Log.v("Message", "onBindViewHolder_r");
        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);
    }

    // 전체 몇 개인지 알려줌
    @Override
    public int getItemCount() {
        Log.v("Message", "getItemCount_r");
        return titles.length;
    }
}
