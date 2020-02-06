package com.kgfsl.ecampusstudent.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgfsl.ecampusstudent.Adapter.Attendance.AttendanceAdapterDate;
import com.kgfsl.ecampusstudent.Adapter.Attendance.AttendanceAdapterMonth;
import com.kgfsl.ecampusstudent.Pojo.Attendance.AttendanceDate;
import com.kgfsl.ecampusstudent.Pojo.Attendance.AttendanceMonth;
import com.kgfsl.ecampusstudent.R;
import com.kgfsl.ecampusstudent.URL;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceFragment extends Fragment {
    View v;
    RecyclerView hRV, vRV;
    String id;

    public AttendanceFragment() {

    }
    @SuppressLint("ValidFragment")
    public AttendanceFragment(String id) {

        this.id=id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_attendance, container, false);
        initialize();
        return v;
    }

    private void initialize() {
        hRV = (RecyclerView) v.findViewById(R.id.horzon_recyclerview);
        vRV = (RecyclerView) v.findViewById(R.id.vertical_recyclerview);
        LinearLayoutManager hLinearLayoutManager = new LinearLayoutManager(v.getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager vLinearLayoutManager = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);
        hRV.setLayoutManager(hLinearLayoutManager);
        vRV.setLayoutManager(vLinearLayoutManager);
        getAttendance();
    }


    @Override
    public void onStart() {
        super.onStart();
        getAttendance();
    }

    public void getAttendance() {

        String json = "{\n" +
                "  \"status\":true,\n" +
                "  \"Sem\":[\"II\"],\n" +
                "  \"months\":[\"JAN\",\"FEB\",\"MAR\",\"APR\",\"MAY\",\"JUN\",\"JUL\",\"AUG\",\"SEP\",\"OCT\",\"NOV\",\"DEC\"]\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            AttendanceMonth response = objectMapper.readValue(json, AttendanceMonth.class);
            if (response.getStatus()) {

                AttendanceAdapterMonth attendanceAdapterMonth = new AttendanceAdapterMonth(v.getContext(), response, new AttendanceAdapterMonth.OnClickListner() {
                    @Override
                    public void MonthClickListner(AttendanceMonth attendanceMonth, int position) {
                        AttendanceDate(attendanceMonth.getMonths().get(position));
                    }
                });
             //   hRV.setAdapter(attendanceAdapterMonth);
               // attendanceAdapterMonth.notifyDataSetChanged();
                AttendanceDate("");

            }
        } catch (IOException e) {
            e.printStackTrace();
            toast(String.valueOf(e));
        }

    }

    private void AttendanceDate(String month) {

        String json="{\"status\":true,\"punchcount\":6,\"Dates\":[{\"date\":\"10-10-2017\",\"day\":\"Monday\",\"dayStatus\":\"W\",\"att_report\":[\"P\",\"P\",\"A\",\"P\",\"P\",\"A\"]},{\"date\":\"11-10-2017\",\"day\":\"Tuesday\",\"dayStatus\":\"W\",\"att_report\":[\"P\",\"P\",\"P\",\"P\",\"P\",\"P\"]},{\"date\":\"12-10-2017\",\"day\":\"Wednesday\",\"dayStatus\":\"W\",\"att_report\":[\"P\",\"P\",\"P\",\"A\",\"P\",\"P\"]},{\"date\":\"13-10-2017\",\"day\":\"Thursday\",\"dayStatus\":\"W\",\"att_report\":[\"P\",\"P\",\"A\",\"P\",\"P\",\"A\"]},{\"date\":\"14-10-2017\",\"day\":\"Friday\",\"dayStatus\":\"W\",\"att_report\":[\"A\",\"P\",\"P\",\"P\",\"P\",\"P\"]},{\"date\":\"15-10-2017\",\"day\":\"Saturday\",\"dayStatus\":\"W\",\"att_report\":[\"P\",\"A\",\"P\",\"A\",\"P\",\"P\"]},{\"date\":\"17-10-2017\",\"day\":\"Monday\",\"dayStatus\":\"W\",\"att_report\":[\"P\",\"P\",\"A\",\"P\",\"P\",\"A\"]},{\"date\":\"18-10-2017\",\"day\":\"Tuesday\",\"dayStatus\":\"W\",\"att_report\":[\"P\",\"P\",\"A\",\"P\",\"P\",\"P\"]},{\"date\":\"19-10-2017\",\"day\":\"Wednesday\",\"dayStatus\":\"W\",\"att_report\":[\"A\",\"P\",\"A\",\"A\",\"P\",\"A\"]}]}";
        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.attendancedetails, new Response.Listener<String>() {
            @Override
            public void onResponse(String response1) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {

                    AttendanceDate response = objectMapper.readValue(response1, AttendanceDate.class);
                    if (response.getStatus()) {
                        AttendanceAdapterDate attendanceAdapterDate = new AttendanceAdapterDate(v.getContext(),response);
                        vRV.setAdapter(attendanceAdapterDate);
                        attendanceAdapterDate.notifyDataSetChanged();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    toast(String.valueOf(e));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                toast(String.valueOf(error));
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("id", id);


                return params;
            }
        };
        requestQueue.add(stringRequest);


    }


    private void toast(String toast) {
        Toast.makeText(v.getContext(), toast, Toast.LENGTH_SHORT).show();
    }

}
