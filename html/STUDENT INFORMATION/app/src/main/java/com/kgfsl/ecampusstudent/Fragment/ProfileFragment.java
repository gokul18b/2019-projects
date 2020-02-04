package com.kgfsl.ecampusstudent.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kgfsl.ecampusstudent.R;
import com.kgfsl.ecampusstudent.URL;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
TextView name,clas,email,age,dob,mobile;
View v;
String id;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ProfileFragment(String ids) {
        // Required empty public constructor
        this.id=ids;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_profile, container, false);
        name=(TextView)v.findViewById(R.id.p_name);
        clas=(TextView)v.findViewById(R.id.p_class);
        email=(TextView)v.findViewById(R.id.p_email);
        age=(TextView)v.findViewById(R.id.p_age);
        dob=(TextView)v.findViewById(R.id.p_dob);
        mobile=(TextView)v.findViewById(R.id.p_mobile);


        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.profile+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    name.setText(jsonObject.getString("name"));
                    clas.setText(jsonObject.getString("classname"));
                    email.setText(jsonObject.getString("email"));
                    age.setText(jsonObject.getString("age"));
                    dob.setText(jsonObject.getString("dob"));
                    mobile.setText(jsonObject.getString("mobile"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        return v;
    }

}
