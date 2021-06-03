package com.aoslec.customadapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    private Context mContext = null;
    // context 를 ACTIVITY 라고 생각해도 됨
    private int layout = 0;
    private ArrayList<Weater> data = null;
    private LayoutInflater inflater = null;

    public WeatherAdapter(Context mContext, int layout, ArrayList<Weater> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 레이아웃 안에 레이아웃 넣어준 걸 iflater (xml 파일 통째를 inflator 로 생각)
    }

    @Override
    public int getCount() {
        // arraylist의 사이즈 / 몇 번 돌아라 주는 것
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // position 이 몇 번째를 클릭했는지 알려줄 것임
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 데이터가 들어가는 방 만들기
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView iv_icon = convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);

        // 데이터 넣어주기 (arraylist의 첫 번째 줄의 day를 가져온 것임)
        tv_day.setText(data.get(position).getDay() + " ");
        iv_icon.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        // 홀짝 수로 색 바꿔주기
        if(position % 2 == 1){
            // 한 줄이 컨버트뷰다
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x2000ff00);
        }
        // 꼭 convertView로 리턴해줘야 함!!!! public View 이기 때문에! view는 convertView라고 선언했기에!
        return convertView;
    }
}
