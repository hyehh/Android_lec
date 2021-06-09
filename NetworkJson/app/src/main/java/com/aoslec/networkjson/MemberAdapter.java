package com.aoslec.networkjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<JsonMember> data = null;
    private LayoutInflater inflater = null;

    public MemberAdapter(Context mContext, int layout, ArrayList<JsonMember> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        // inflater는 타입이 있기 때문에 생성자 만들 때 사용이 불가능함
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getAge();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // this.layout 이 activity_main.xml
        convertView = inflater.inflate(this.layout, parent, false);
        // convertView가 이제 이름들을 알게 됨! 이거 연결해줘야함
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_age = convertView.findViewById(R.id.tv_age);
        TextView tv_hobbies = convertView.findViewById(R.id.tv_hobbies);
        TextView tv_no = convertView.findViewById(R.id.tv_no);
        TextView tv_id = convertView.findViewById(R.id.tv_id);
        TextView tv_pw = convertView.findViewById(R.id.tv_pw);

        tv_name.setText("Name : " + data.get(position).getName());
        tv_age.setText("Age : " + data.get(position).getAge());
        tv_hobbies.setText("Hobby : " + data.get(position).getHobbies());
        tv_no.setText("No : " + data.get(position).getNo());
        tv_id.setText("Id : " + data.get(position).getId());
        tv_pw.setText("Pw : " + data.get(position).getPw());

        if(position % 2 == 1){
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x500000ff);
        }
        return convertView;
    }
}
