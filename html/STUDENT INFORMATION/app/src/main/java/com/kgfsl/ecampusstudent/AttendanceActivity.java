package com.kgfsl.ecampusstudent;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kgfsl.ecampusstudent.Activity.ClassListActivity;
import com.kgfsl.ecampusstudent.Activity.ClassModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AttendanceActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    String id;
    URL url;
    AttendanceListAdapter attendanceListAdapter;
    Button submit;
     ArrayList<AttendanceModel> data =new ArrayList<>();
     RadioGroup radioGroup;
    AttendanceModel attendanceModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        submit=(Button)findViewById(R.id.submit);
        id = getIntent().getStringExtra("id");
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        radioGroup = (RadioGroup) findViewById(R.id.radio);

        getStudentList(id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AttendanceActivity.this);
                builder.setTitle("Attendance Register");
                builder.setMessage("Are You sure want to Register Attendance!");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        calculateAttendance();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    private void calculateAttendance(){
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<data.size();i++){
            try {
                JSONObject dataObj = new JSONObject();
                int id = data.get(i).getId();

                dataObj.put("sid", data.get(i).getId());
                if (data.get(i).getPos() == true) {

                    dataObj.put("status", "P");


                } else if (data.get(i).getPos() == false) {
                    dataObj.put("status", "A");
                }
                jsonArray.put(dataObj);

            }catch (JSONException e) {
                e.printStackTrace();
            }

        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("data",jsonArray);
            jsonObject.put("cid",id);
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedId);

            jsonObject.put("hour",radioButton.getText());
            pushAttendance(String.valueOf(jsonObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void pushAttendance(final String data) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.attendanceregister, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                toast(response);
                //getStudentList(id);
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
                params.put("data", data);


                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void getStudentList(final String id) {

         data=new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.studentlist, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for(int i=0;i<jsonArray.length();i++){
                       JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        int id = jsonObject1.getInt("id");
                        String name = jsonObject1.getString("name");


                        data.add(new AttendanceModel(id,name));

                    }

                    attendanceListAdapter = new AttendanceListAdapter(AttendanceActivity.this,data,id);
                    recyclerView.setAdapter(attendanceListAdapter);
                } catch (JSONException e) {
                    toast(String.valueOf(e));
                    e.printStackTrace();
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

    private void toast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
}