package com.kgfsl.ecampusstudent.Adapter.Attendance;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kgfsl.ecampusstudent.Pojo.Attendance.AttendanceMonth;
import com.kgfsl.ecampusstudent.R;


/**
 * Created by gokul on 24-10-2017.
 */

public class AttendanceAdapterMonth extends RecyclerView.Adapter<AttendanceAdapterMonth.Holder> {
    AttendanceMonth attendanceMonth;
    Context ctx;
    int selectedPosition = 0;

    final OnClickListner listner;

    public AttendanceAdapterMonth(Context context, AttendanceMonth response, OnClickListner listner) {

        this.attendanceMonth = response;
        this.ctx = context;
        this.listner = listner;

    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.attendancemonth, parent, false));

    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.txtmon.setText(attendanceMonth.getMonths().get(position));

        if (selectedPosition == position)
            holder.itemView.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
        else
            holder.itemView.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimary));

        holder.bind(attendanceMonth, listner, position);


    }

    @Override
    public int getItemCount() {

        return attendanceMonth.getMonths().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        LinearLayout month;
        TextView txtmon;

        public Holder(View itemView) {
            super(itemView);
            month = (LinearLayout) itemView.findViewById(R.id.att_month);
            txtmon = (TextView) itemView.findViewById(R.id.txt_mon);
        }

        public void bind(final AttendanceMonth attendanceMonth, final OnClickListner listner, final int position) {

            month.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.MonthClickListner(attendanceMonth, position);

                    selectedPosition = position;
                    notifyDataSetChanged();


                }
            });
        }
    }

    public interface OnClickListner {
        void MonthClickListner(AttendanceMonth attendanceMonth, int position);
    }

}
