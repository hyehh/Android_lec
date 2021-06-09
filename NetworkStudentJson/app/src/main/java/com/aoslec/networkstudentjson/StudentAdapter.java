package com.aoslec.networkstudentjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    // property
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Students> students = null;
    private LayoutInflater inflater = null;

    // constructor
    public StudentAdapter(Context mContext, int layout, ArrayList<Students> students) {
        this.mContext = mContext;
        this.layout = layout;
        this.students = students;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position).getCode();
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

        tv_code.setText("Code : " + students.get(position).getCode());
        tv_name.setText("Name : " + students.get(position).getName());
        tv_dept.setText("Dept : " + students.get(position).getDept());
        tv_phone.setText("Phone : " + students.get(position).getPhone());

        if(position % 2 == 1){
            convertView.setBackgroundColor(0x60ffffff);
        }else {
            convertView.setBackgroundColor(0x60000000);
        }
        return convertView;
    }
}
