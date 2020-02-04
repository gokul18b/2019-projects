package com.kgfsl.ecampusstudent.Adapter.Attendance;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kgfsl.ecampusstudent.Pojo.Attendance.AttendanceDate;
import com.kgfsl.ecampusstudent.R;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by gokul on 24-10-2017.
 */

public class AttendanceAdapterDate extends RecyclerView.Adapter<AttendanceAdapterDate.Holder> {
    AttendanceDate attendanceDate;
    Context ctx;


    public AttendanceAdapterDate(Context context, AttendanceDate response) {
        this.attendanceDate = response;
        this.ctx = context;


    }


    @Override
    public AttendanceAdapterDate.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AttendanceAdapterDate.Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_row, parent, false));

    }

    @Override
    public void onBindViewHolder(AttendanceAdapterDate.Holder holder, int position) {
        holder.date.setText(attendanceDate.getDates().get(position).getDate());
        holder.day.setText(attendanceDate.getDates().get(position).getDay());

        JSONArray jsonArray = new JSONArray(attendanceDate.getDates().get(position).getAttReport());
        try {

            String p1 = jsonArray.get(0).toString();
            String p2 = jsonArray.get(1).toString();
            String p3 = jsonArray.get(2).toString();
            String p4 = jsonArray.get(3).toString();
            String p5 = jsonArray.get(4).toString();
            String p6 = jsonArray.get(5).toString();

//            holder.p1.setText(p1);
//            holder.p2.setText(p2);
//            holder.p3.setText(p3);
//            holder.p4.setText(p4);
//            holder.p5.setText(p5);
//            holder.p6.setText(p6);

            if (p1.equals("A")) {
                holder.p1.setBackgroundResource(R.drawable.circlered);
            } else if (p1.equals("P")) {
                holder.p1.setBackgroundResource(R.drawable.circlegreen);
            }else {
                holder.p1.setBackgroundResource(R.drawable.circlegrey);
            }
            if (p2.equals("A")) {
                holder.p2.setBackgroundResource(R.drawable.circlered);
            } else if (p2.equals("P")) {
                holder.p2.setBackgroundResource(R.drawable.circlegreen);
            } else {
                holder.p2.setBackgroundResource(R.drawable.circlegrey);
            }

            if (p3.equals("A")) {
                holder.p3.setBackgroundResource(R.drawable.circlered);
            } else if (p3.equals("P")) {
                holder.p3.setBackgroundResource(R.drawable.circlegreen);
            } else {
                holder.p3.setBackgroundResource(R.drawable.circlegrey);
            }

            if (p4.equals("A")) {
                holder.p4.setBackgroundResource(R.drawable.circlered);
            } else if (p4.equals("P")) {
                holder.p4.setBackgroundResource(R.drawable.circlegreen);
            } else {
                holder.p4.setBackgroundResource(R.drawable.circlegrey);
            }

            if (p5.equals("A")) {
                holder.p5.setBackgroundResource(R.drawable.circlered);
            } else if (p5.equals("P")) {
                holder.p5.setBackgroundResource(R.drawable.circlegreen);
            } else {
                holder.p5.setBackgroundResource(R.drawable.circlegrey);
            }

            if (p6.equals("A")) {
                holder.p6.setBackgroundResource(R.drawable.circlered);
            } else if (p6.equals("P")) {
                holder.p6.setBackgroundResource(R.drawable.circlegreen);
            } else {
                holder.p6.setBackgroundResource(R.drawable.circlegrey);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            toast(e.toString());
        }


    }

    private void toast(String toasr) {
        Toast.makeText(ctx, toasr, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {

        return attendanceDate.getDates().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView date, day, p1, p2, p3, p4, p5, p6, p7;

        public Holder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            day = (TextView) itemView.findViewById(R.id.day);
            p1 = (TextView) itemView.findViewById(R.id.p1);
            p2 = (TextView) itemView.findViewById(R.id.p2);
            p3 = (TextView) itemView.findViewById(R.id.p3);
            p4 = (TextView) itemView.findViewById(R.id.p4);
            p5 = (TextView) itemView.findViewById(R.id.p5);
            p6 = (TextView) itemView.findViewById(R.id.p6);
            p7 = (TextView) itemView.findViewById(R.id.p7);

        }


    }

}