package com.kgfsl.ecampusstudent;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.kgfsl.ecampusstudent.Activity.MainActivity;

import java.util.ArrayList;

/**
 * Created by Madhan on 25-12-2017.
 */

public class AttendanceListAdapter extends RecyclerView.Adapter<AttendanceListAdapter.Holder> {
    Context ctx;
    ArrayList<AttendanceModel> datas;
    String cid;

    public AttendanceListAdapter(Context context, ArrayList<AttendanceModel> data ,String cid){
        this.ctx=context;
        this.datas=data;
        this.cid=cid;

    }
    @Override
    public AttendanceListAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AttendanceListAdapter.Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_attendance,parent,false));
    }

    @Override
    public void onBindViewHolder(AttendanceListAdapter.Holder holder, final int position) {

        holder.name.setText(datas.get(position).getName());
        holder.switchb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    datas.get(position).setPos(true);
                }else{
                    datas.get(position).setPos(false);
                }
            }
        });
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, MainActivity.class);
                intent.putExtra("id",String.valueOf(datas.get(position).getId()));
                intent.putExtra("cid",String.valueOf(cid));
                intent.putExtra("FLAGG","ATT");
                ctx.startActivity(intent);
            }
        });


            holder.switchb.setChecked(datas.get(position).getPos());



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
        Switch switchb;
        LinearLayout row;
        public Holder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            switchb =(Switch)itemView.findViewById(R.id.switchb);
            row =(LinearLayout) itemView.findViewById(R.id.row);

        }
    }
}

