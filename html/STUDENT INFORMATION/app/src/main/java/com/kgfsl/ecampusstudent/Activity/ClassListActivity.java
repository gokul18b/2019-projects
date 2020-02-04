package com.kgfsl.ecampusstudent.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kgfsl.ecampusstudent.ClassListAdapter;
import com.kgfsl.ecampusstudent.R;
import com.kgfsl.ecampusstudent.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClassListActivity extends AppCompatActivity {
RecyclerView recyclerView;
LinearLayoutManager linearLayoutManager;
String FLAG,id;
URL url;
ClassListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        FLAG = getIntent().getStringExtra("FLAG");
        id = getIntent().getStringExtra("id");
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        getClassList();
    }

    private void getClassList() {
        final ArrayList<String> idList=new ArrayList<>();
        final ArrayList<String> cnameList=new ArrayList<>();
        final ArrayList<ClassModel> data=new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url.classlist, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);;
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String id = jsonObject1.getString("id");
                        String cls = jsonObject1.getString("class");

                        idList.add(id);
                        cnameList.add(cls);
                        data.add(new ClassModel(id,cls));
                    }

                    listAdapter = new ClassListAdapter(ClassListActivity.this,data,FLAG,id);
                    recyclerView.setAdapter(listAdapter);
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
        });
        requestQueue.add(stringRequest);
    }

    private void toast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
}
