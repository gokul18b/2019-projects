package com.kgfsl.ecampusstudent.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kgfsl.ecampusstudent.R;
import com.kgfsl.ecampusstudent.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manivasagam on 08-11-2017.
 */

public class FeedbackFragment extends Fragment {
EditText cat,des;
View v;

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_feedback, container, false);
        cat=(EditText)v.findViewById(R.id.category);
        des=(EditText)v.findViewById(R.id.description);

        Button send =(Button)v.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = cat.getText().toString().trim();
                String description = des.getText().toString().trim();
                if(category.length()!=0 || description.length()!=0) {
                    sendFeedback(category,description);
                }else{
                    toast("Enter required fields");
                }
            }
        });
        return v;
    }

    private void toast(String s) {
        Toast.makeText(v.getContext(),s,Toast.LENGTH_SHORT).show();
    }

    private void sendFeedback(final String c, final String d) {
        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.postfeedback, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                toast(response);
                toast("Feedback sucessfully send...");
                cat.setText("");
                des.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("cat", c);
                params.put("des", d);

                return params;
            }
        };;
        requestQueue.add(stringRequest);
    }

}
