package com.kgfsl.ecampusstudent.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.kgfsl.ecampusstudent.AboutUsActivity;
import com.kgfsl.ecampusstudent.ProfileActivity;
import com.kgfsl.ecampusstudent.R;

public class TeacherHomeActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout attendance,homework,profile,feedback,about,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);
        attendance = (LinearLayout)findViewById(R.id.teacher_attendance);
        homework = (LinearLayout)findViewById(R.id.teacher_homework);
        profile = (LinearLayout)findViewById(R.id.teacher_profile);
        feedback = (LinearLayout)findViewById(R.id.teacher_feedback);
        about = (LinearLayout)findViewById(R.id.teacher_about);
        logout = (LinearLayout)findViewById(R.id.teacher_logout);
        attendance.setOnClickListener(this);
        profile.setOnClickListener(this);
        homework.setOnClickListener(this);
        feedback.setOnClickListener(this);
        about.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.teacher_profile:
                Intent pro = new Intent(TeacherHomeActivity.this,ProfileActivity.class);
                pro.putExtra("FLAG","Attendance");
                pro.putExtra("id",getIntent().getStringExtra("id"));
                startActivity(pro);
                break;
            case R.id.teacher_attendance:
                Intent intent = new Intent(TeacherHomeActivity.this,ClassListActivity.class);
                intent.putExtra("FLAG","Attendance");
                intent.putExtra("id",getIntent().getStringExtra("id"));
                startActivity(intent);
                break;
            case R.id.teacher_homework:
                Intent home = new Intent(TeacherHomeActivity.this,ClassListActivity.class);
                home.putExtra("FLAG","homework");
                home.putExtra("id",getIntent().getStringExtra("id"));
                startActivity(home);
                break;
            case R.id.teacher_about:
                Intent about = new Intent(TeacherHomeActivity.this,AboutUsActivity.class);
                startActivity(about);
                break;
            case R.id.teacher_feedback:
                Intent feedback = new Intent(TeacherHomeActivity.this,FeedbackActivity.class);
                startActivity(feedback);
                break;
            case R.id.teacher_logout:
                Intent log = new Intent(TeacherHomeActivity.this,LoginActivity.class);
                log.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(log);
                break;
        }

    }
}
