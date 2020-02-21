package com.kgfsl.ecampusstudent.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kgfsl.ecampusstudent.Pojo.Login.Login;
import com.kgfsl.ecampusstudent.Pojo.Login.Result;
import com.kgfsl.ecampusstudent.R;
import com.kgfsl.ecampusstudent.Retrofit.APIClient;
import com.kgfsl.ecampusstudent.Retrofit.APIInterface;
import com.kgfsl.ecampusstudent.URL;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @InjectView(R.id.signin)
    Button signin;
    @InjectView(R.id.password)
    EditText password;
    @InjectView(R.id.login_username)
    EditText username;
    boolean isVisible = false;
    @InjectView(R.id.login_forgotpass)
    TextView forgotpass;
    APIInterface apiInterface;
    RequestQueue requestQueue;

    URL url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        apiInterface = APIClient.getClient().create(APIInterface.class);


        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (password.getRight() - password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (!isVisible) {
                            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_password, 0, R.drawable.ic_action_visible_eye, 0);
                            isVisible = true;
                            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        } else {
                            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_password, 0, R.drawable.ic_action_invisible_eye, 0);


                            isVisible = false;
                            password.setInputType(InputType.TYPE_CLASS_TEXT |
                                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        }


                        return true;
                    }
                }
                return false;
            }
        });
    }


    private void toast(String toast) {
        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.signin, R.id.login_forgotpass})
    public void OnClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.signin:
            String uname=username.getText().toString().trim();
            String pass =  password.getText().toString().trim();
            if(uname.length()!=0 && pass.length()!=0) {
               // intent = new Intent(this, MainActivity.class);
                //startActivity(intent);
                login(uname,pass);

            }else{
                toast("Enter Username and password");
            }
                break;
            case R.id.login_forgotpass:
                intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }

    private void login(final String username, final String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url.login, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject1 = new JSONObject(response);
                    toast(response);
                    JSONObject jsonObject11 = jsonObject1.getJSONObject("data");

                    if (jsonObject11.getInt("status") == 1) {
                        if(jsonObject11.getString("user_type").equals("S")) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("id", String.valueOf(jsonObject11.getInt("id")));
                            intent.putExtra("cid", String.valueOf(jsonObject11.getInt("cid")));
                            startActivity(intent);
                        }else if(jsonObject11.getString("user_type").equals("T")){
                            Intent intent = new Intent(LoginActivity.this, TeacherHomeActivity.class);
                            intent.putExtra("id", String.valueOf(jsonObject11.getInt("id")));
                            startActivity(intent);
                        }

                    } else if (jsonObject11.getInt("status") == 2) {
                        Toast.makeText(getApplicationContext(), String.valueOf(jsonObject11.getString("msg")), Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), String.valueOf(e), Toast.LENGTH_LONG).show();

                }


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
                params.put("username", username);
                    params.put("password", password);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


}

