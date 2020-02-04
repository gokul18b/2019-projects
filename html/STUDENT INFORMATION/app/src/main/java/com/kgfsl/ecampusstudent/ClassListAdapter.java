package com.kgfsl.ecampusstudent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kgfsl.ecampusstudent.Activity.ClassListActivity;
import com.kgfsl.ecampusstudent.Activity.ClassModel;

import java.util.ArrayList;

/**
 * Created by Madhan on 25-12-2017.
 */

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.Holder> {
    Context ctx;
    ArrayList<ClassModel> datas;
    String FLAG;
    String id;
    public ClassListAdapter(Context context, ArrayList<ClassModel> data, String flag, String id) {
        this.ctx=context;
        this.datas=data;
        this.FLAG=flag;
        this.id=id;
    }
    @Override
    public ClassListAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClassListAdapter.Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_class,parent,false));
    }

    @Override
    public void onBindViewHolder(ClassListAdapter.Holder holder, final int position) {

        holder.name.setText(datas.get(position).getCls());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FLAG.equals("Attendance")) {
                    Intent intent = new Intent(ctx, AttendanceActivity.class);
                    intent.putExtra("id", datas.get(position).getId());
                    ctx.startActivity(intent);
                }else if(FLAG.equals("homework")){
                    Intent intent = new Intent(ctx, HomeWorkActivity.class);
                    intent.putExtra("tid",id);
                    intent.putExtra("id", datas.get(position).getId());
                    ctx.startActivity(intent);
                }
            }
        });



    }

    private void toast(String s) {
        Toast.makeText(ctx,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {

        return datas.size();

    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout row;
        public Holder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.row_name);
            row=(LinearLayout) itemView.findViewById(R.id.row);

        }
    }

    public interface  onClick{
        public void onclick();
    }
}

