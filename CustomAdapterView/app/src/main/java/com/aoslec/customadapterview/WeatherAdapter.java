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
    // layout 은 숫자임!
    private ArrayList<Weater> data = null;
    private LayoutInflater inflater = null;

    public WeatherAdapter(Context mContext, int layout, ArrayList<Weater> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 레이아웃 안에 레이아웃 넣어준 걸 iflater (xml 파일 통째를 inflator 로 생각) bean에 있는 데이터를 가져오는 게 inflator
        // 위에 차곡차곡 쌓는 방식
    }

    // BaseAdapter 만들었을 때 override 된 부분은 반드시 사용함
    @Override
    public int getCount() {
        // arraylist의 사이즈 / 몇 번 돌아라 주는 것
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // 클릭했을 때 이 값을 가지고 뭘 하겠다는 것
        // position 이 몇 번째를 클릭했는지 알려줄 것임 (0번 부터임)
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        // 위치를 가져온다
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 데이터가 들어가는 방 만들기
        if(convertView == null){ // 제일 처음 시작은 무조건 null 값임! (계속 반복함)
            // 리스트 뷰에 쌓으려고 하는데 그 전에 장소를 세팅해주는 것임
            // inflator 는 layout이 들어가는데 this.layout은 activity_main.xml을 의미함!
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
            // 0x = #이라고 생각하면 됨! (0x는 16진수임)
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x2000ff00);
        }
        // 꼭 convertView로 리턴해줘야 함!!!! public View 이기 때문에! view는 convertView라고 선언했기에!
        return convertView;
    }
}
