package com.kgfsl.ecampusstudent.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kgfsl.ecampusstudent.Activity.ClassModel;
import com.kgfsl.ecampusstudent.AttendanceActivity;
import com.kgfsl.ecampusstudent.ClassListAdapter;
import com.kgfsl.ecampusstudent.HomeWorkActivity;
import com.kgfsl.ecampusstudent.HomeworkModel;
import com.kgfsl.ecampusstudent.R;

import java.util.ArrayList;

/**
 * Created by Madhan on 27-12-2017.
 */

public class AssignmentAdapter  extends RecyclerView.Adapter<AssignmentAdapter.Holder> {
    Context ctx;
    ArrayList<HomeworkModel> datas;
    String FLAG;
    String id;
    public AssignmentAdapter(Context context, ArrayList<HomeworkModel> data) {
        this.ctx=context;
        this.datas=data;

    }
    @Override
    public AssignmentAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AssignmentAdapter.Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_homework,parent,false));
    }

    @Override
    public void onBindViewHolder(AssignmentAdapter.Holder holder, final int position) {

        holder.name.setText(datas.get(position).getName());
        holder.des.setText(datas.get(position).getDes());
        holder.date.setText(datas.get(position).getDate());
    }

    private void toast(String s) {
        Toast.makeText(ctx,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {

        return datas.size();

    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name,des,date;

        public Holder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.sub);
            des=(TextView) itemView.findViewById(R.id.des);
            date=(TextView) itemView.findViewById(R.id.date);


        }
    }

    public interface  onClick{
        public void onclick();
    }
}