package com.kgfsl.ecampusstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
String id;
    TextView name,clas,email,age,dob,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        id=getIntent().getStringExtra("id");

        name=(TextView)findViewById(R.id.p_name);
        clas=(TextView)findViewById(R.id.p_class);
        email=(TextView)findViewById(R.id.p_email);
        age=(TextView)findViewById(R.id.p_age);
        dob=(TextView)findViewById(R.id.p_dob);
        mobile=(TextView)findViewById(R.id.p_mobile);



        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
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


    }
}
