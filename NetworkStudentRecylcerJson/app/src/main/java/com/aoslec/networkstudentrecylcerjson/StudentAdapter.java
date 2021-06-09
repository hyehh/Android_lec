package com.aoslec.networkstudentrecylcerjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Students> students = null;
    private LayoutInflater inflater = null;

    public StudentAdapter(Context mContext, int layout, ArrayList<Students> students) {
        this.mContext = mContext;
        this.layout = layout;
        this.students = students;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_code, tv_name, tv_dept, tv_phone;

        public ViewHolder(View studentView){
            super(studentView);
            tv_code = studentView.findViewById(R.id.tv_code);
            tv_name = studentView.findViewById(R.id.tv_name);
            tv_dept = studentView.findViewById(R.id.tv_dept);
            tv_phone = studentView.findViewById(R.id.tv_phone);

            // 셀 세팅
            studentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(studentView, students.get(position).getName() + " is Clicked", Snackbar.LENGTH_SHORT).setAction("", null).show();
                }
            });
        }
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {
        holder.tv_code.setText(students.get(position).getCode());
        holder.tv_name.setText("Name : " + students.get(position).getName());
        holder.tv_dept.setText("Dept : " + students.get(position).getDept());
        holder.tv_phone.setText("Phone : " + students.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
