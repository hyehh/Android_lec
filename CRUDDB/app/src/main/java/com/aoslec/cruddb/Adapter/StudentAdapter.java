package com.aoslec.cruddb.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aoslec.cruddb.Bean.Student;
import com.aoslec.cruddb.R;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    // 검색 시에만 사용

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Student> data = null;
    private LayoutInflater inflater = null;

    public StudentAdapter(Context mContext, int layout, ArrayList<Student> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        // 나는 이것만 쓸꺼야 하는 애! 변하지 않는 것이기 때문에 굳이 파라미터에 쓰지 않아도 됨!
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getCode();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(this.layout, parent, false);
        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phone);

        tv_code.setText("학번 : " + data.get(position).getCode());
        tv_name.setText("성명 : " + data.get(position).getName());
        tv_dept.setText("전공 : " + data.get(position).getDept());
        tv_phone.setText("전화번호 : " + data.get(position).getPhone());

        return convertView;
    }
}
