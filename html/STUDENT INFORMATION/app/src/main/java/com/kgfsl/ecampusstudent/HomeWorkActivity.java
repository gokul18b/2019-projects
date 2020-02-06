package com.kgfsl.ecampusstudent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kgfsl.ecampusstudent.Activity.LoginActivity;
import com.kgfsl.ecampusstudent.Activity.MainActivity;
import com.kgfsl.ecampusstudent.Activity.TeacherHomeActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HomeWorkActivity extends AppCompatActivity {
    Button submit;
    EditText subject, description;
    String tid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);
        tid = getIntent().getStringExtra("tid");
        submit = (Button) findViewById(R.id.submit);
        subject = (EditText) findViewById(R.id.subject);
        description = (EditText) findViewById(R.id.description);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String sub = subject.getText().toString().trim();
                final String des = description.getText().toString().trim();
                if (sub.length() == 0) {
                    toast("Enter Subject");
                } else if (des.length() == 0) {
                    toast("Enter Description");
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(HomeWorkActivity.this);
                    builder.setTitle("Homework Register");
                    builder.setMessage("Are You sure want to update Homeworks!");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            registerHomeWork(sub, des);
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
            }
        });

    }

    private void registerHomeWork(final String sub, final String des) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.putHomework, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                subject.setText("");
                description.setText("");

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), String.valueOf(error), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("sub", sub);
                params.put("des", des);
                params.put("givenby", tid);
                params.put("cid",getIntent().getStringExtra("id"));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void toast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}
