package com.kgfsl.ecampusstudent.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kgfsl.ecampusstudent.Activity.LoginActivity;
import com.kgfsl.ecampusstudent.Pojo.Login.Login;
import com.kgfsl.ecampusstudent.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    View v;
    @InjectView(R.id.home_profile)
    LinearLayout profile;
    @InjectView(R.id.home_attendance)
    LinearLayout attendance;
    @InjectView(R.id.home_announcement)
    LinearLayout announcement;
    @InjectView(R.id.home_fees)
    LinearLayout fees;
    @InjectView(R.id.home_evalvation)
    LinearLayout evalvation;
    @InjectView(R.id.home_gallery)
    LinearLayout gallery;
    @InjectView(R.id.home_timetable)
    LinearLayout timetable;
    @InjectView(R.id.home_aboutus)
    LinearLayout aboutus;
    @InjectView(R.id.home_feedback)
    LinearLayout feedback;

    @InjectView(R.id.home_logout)
    LinearLayout logout;

    String ids,cid;
    public HomeFragment() {
        // Required empty public constructor

    }
    @SuppressLint("ValidFragment")
    public HomeFragment(String id,String cid) {
        // Required empty public constructor
this.ids=id;
this.cid=cid;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    @OnClick({R.id.home_profile, R.id.home_attendance, R.id.home_announcement, R.id.home_fees, R.id.home_evalvation, R.id.home_assignment, R.id.home_todayclass, R.id.home_gallery, R.id.home_timetable,R.id.home_feedback,R.id.home_aboutus,R.id.home_logout})
    public void pickDoor(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.home_profile:
                fragment = new ProfileFragment(ids);
                break;
            case R.id.home_attendance:
                fragment = new AttendanceFragment(ids);
                break;
            case R.id.home_announcement:
                fragment = new AnnouncementFragment();
                break;
            case R.id.home_fees:
                fragment = new FeesFragment();
                break;
            case R.id.home_evalvation:
                fragment = new EvaluvationFragment();
                break;
            case R.id.home_assignment:
                fragment = new AssignmentFragment(cid);
                break;
            case R.id.home_todayclass:
                fragment = new TodaysClassFragment();
                break;
            case R.id.home_gallery:
                fragment = new GalleryFragment();
                break;
            case R.id.home_timetable:
                fragment = new TimeTableFragment();
                break;
            case R.id.home_feedback:
                fragment = new FeedbackFragment();
                break;
            case R.id.home_aboutus:
                fragment = new AboutUsFragment();
                break;
            case R.id.home_logout:
                Intent intent=new Intent(v.getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack("Home");
            ft.commit();
        }
    }

    private void toast(String msg) {
        Toast.makeText(v.getContext(), msg, Toast.LENGTH_SHORT).show();
    }


}
