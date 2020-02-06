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
import com.kgfsl.ecampusstudent.Activity.ClassListActivity;
import com.kgfsl.ecampusstudent.Activity.ClassModel;
import com.kgfsl.ecampusstudent.ClassListAdapter;
import com.kgfsl.ecampusstudent.HomeworkModel;
import com.kgfsl.ecampusstudent.R;
import com.kgfsl.ecampusstudent.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AssignmentAdapter assignmentAdapter;
    View v;
    String cid;

    public AssignmentFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public AssignmentFragment(String cid) {
        this.cid=cid;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_assignment, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        getHomeworkList();
        return v;
    }

    private void getHomeworkList() {

        final ArrayList<String> idList=new ArrayList<>();
        final ArrayList<String> cnameList=new ArrayList<>();
        final ArrayList<HomeworkModel> data=new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.homeworklist, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);;
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String name = jsonObject1.getString("sub");
                        String des = jsonObject1.getString("des");
                        String date = jsonObject1.getString("date");

                        idList.add(name);
                        cnameList.add(des);
                        data.add(new HomeworkModel(name,des,date));
                    }

                    assignmentAdapter = new AssignmentAdapter(v.getContext(),data);
                    recyclerView.setAdapter(assignmentAdapter);
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
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("cid", cid);


                return params;
            }
        };;;
        requestQueue.add(stringRequest);
    }

    private void toast(String s) {
        Toast.makeText(v.getContext(),s,Toast.LENGTH_SHORT).show();
    }

}
