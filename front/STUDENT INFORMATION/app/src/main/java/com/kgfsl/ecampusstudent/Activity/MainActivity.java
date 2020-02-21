package com.kgfsl.ecampusstudent.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kgfsl.ecampusstudent.Fragment.AboutUsFragment;
import com.kgfsl.ecampusstudent.Fragment.AssignmentFragment;
import com.kgfsl.ecampusstudent.Fragment.AnnouncementFragment;
import com.kgfsl.ecampusstudent.Fragment.AttendanceFragment;
import com.kgfsl.ecampusstudent.Fragment.EvaluvationFragment;
import com.kgfsl.ecampusstudent.Fragment.FeedbackFragment;
import com.kgfsl.ecampusstudent.Fragment.FeesFragment;
import com.kgfsl.ecampusstudent.Fragment.GalleryFragment;
import com.kgfsl.ecampusstudent.Fragment.HomeFragment;
import com.kgfsl.ecampusstudent.Fragment.ProfileFragment;
import com.kgfsl.ecampusstudent.Fragment.TimeTableFragment;
import com.kgfsl.ecampusstudent.Fragment.TodaysClassFragment;
import com.kgfsl.ecampusstudent.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public NavigationView navigationView;
    Fragment mainFragment;
    Spinner spinnerItem;
    TextView homeTitle;
    String ids,cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        ids=getIntent().getStringExtra("id");
        cid=getIntent().getStringExtra("cid");





        spinnerItem = (Spinner) findViewById(R.id.spinner);
        homeTitle = (TextView) findViewById(R.id.home_title);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        //toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        Fragment fragment = null;
        fragment = new HomeFragment(ids,cid);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();


        try{
            String FLAGG =getIntent().getStringExtra("FLAGG");
            if(FLAGG.equals("ATT")){
                ids=getIntent().getStringExtra("id");

                Fragment ff = null;
                ff = new AttendanceFragment(ids);
                FragmentTransaction fff = getSupportFragmentManager().beginTransaction();
                fff.replace(R.id.content_frame, ff);
                fff.commit();
            }
        }catch (Exception e)
        {

        }
        navigationView.getMenu().getItem(0).setChecked(true);
        homeTitle.setText(getResources().getString(R.string.title_home));
        spinnerItem.setVisibility(View.INVISIBLE);


        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                mainFragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);
                if (mainFragment instanceof HomeFragment) {
                    homeTitle.setText(getResources().getString(R.string.title_home));
                    navigationView.getMenu().getItem(0).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);

                } else if (mainFragment instanceof ProfileFragment) {

                    homeTitle.setText(getResources().getString(R.string.title_profile));
                    navigationView.getMenu().getItem(1).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);

                } else if (mainFragment instanceof AttendanceFragment) {

                    spinnerItem.setVisibility(View.VISIBLE);
                    homeTitle.setText(getResources().getString(R.string.title_attendance));
                    navigationView.getMenu().getItem(2).setChecked(true);
                    SetSpinnerSemester();

                } else if (mainFragment instanceof AnnouncementFragment) {

                    spinnerItem.setVisibility(View.INVISIBLE);
                    homeTitle.setText(getResources().getString(R.string.title_announcement));
                    navigationView.getMenu().getItem(3).setChecked(true);


                } else if (mainFragment instanceof FeesFragment) {

                    spinnerItem.setVisibility(View.VISIBLE);
                    homeTitle.setText(getResources().getString(R.string.title_fees));
                    navigationView.getMenu().getItem(4).setChecked(true);
                    SetSpinnerSemester();

                }
                else if (mainFragment instanceof EvaluvationFragment) {
                    spinnerItem.setVisibility(View.VISIBLE);
                    homeTitle.setText(getResources().getString(R.string.title_evalvation));
                    navigationView.getMenu().getItem(5).setChecked(true);
                    SetSpinnerSemester();

                }else  if (mainFragment instanceof AssignmentFragment) {
                    homeTitle.setText(getResources().getString(R.string.title_assignment));
                    navigationView.getMenu().getItem(6).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);
                }
                else  if (mainFragment instanceof TodaysClassFragment) {
                    homeTitle.setText(getResources().getString(R.string.title_todaysclass));
                    navigationView.getMenu().getItem(7).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);
                }
                else  if (mainFragment instanceof GalleryFragment) {
                    homeTitle.setText(getResources().getString(R.string.title_galery));
                    navigationView.getMenu().getItem(8).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);
                }
                else  if (mainFragment instanceof TimeTableFragment) {
                    homeTitle.setText(getResources().getString(R.string.title_timetable));
                    navigationView.getMenu().getItem(9).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);
                } else  if (mainFragment instanceof FeedbackFragment) {
                    homeTitle.setText(getResources().getString(R.string.title_feedback));
                    navigationView.getMenu().getItem(10).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);
                }
                else  if (mainFragment instanceof AboutUsFragment) {
                    homeTitle.setText(getResources().getString(R.string.title_about));
                    navigationView.getMenu().getItem(11).setChecked(true);
                    spinnerItem.setVisibility(View.INVISIBLE);
                }


            }
        });

        spinnerItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(mainFragment instanceof AttendanceFragment) {

                    FragmentManager fm = getSupportFragmentManager();
                    AttendanceFragment fragment = (AttendanceFragment) fm.findFragmentById(R.id.content_frame);
                    fragment.getAttendance();

                }else if(mainFragment instanceof  FeesFragment){

                    FragmentManager fm = getSupportFragmentManager();
                    FeesFragment fragment = (FeesFragment) fm.findFragmentById(R.id.content_frame);
                    fragment.getFees();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void SetSpinnerSemester() {
        spinnerItem.setPopupBackgroundResource(R.drawable.spinner_background);
        ArrayList<String> list = new ArrayList<>();
        list.add("SEM I");
        list.add("SEM II");
        list.add("SEM III");
        list.add("SEM IV");
        list.add("SEM V");
        list.add("SEM VI");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
        spinnerItem.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_home) {
            fragment = new HomeFragment(ids,cid);

        } else if (id == R.id.nav_profile) {
            fragment = new ProfileFragment(ids);

        } else if (id == R.id.nav_attendance) {
            fragment = new AttendanceFragment(ids);

        } else if (id == R.id.nav_announcement) {
            fragment = new AnnouncementFragment();

        } else if (id == R.id.nav_fees) {
            fragment = new FeesFragment();

        }else if (id == R.id.nav_evalvation) {
            fragment = new EvaluvationFragment();

        }else if(id==R.id.nav_assignment){
            fragment= new AssignmentFragment();
        }
        else if(id==R.id.nav_todayclass){
            fragment= new TodaysClassFragment();
        }
        else if(id==R.id.nav_gallery){
            fragment = new GalleryFragment();
        }
        else if(id==R.id.nav_timetable){
            fragment = new TimeTableFragment();
        }
        else if(id==R.id.nav_feedback){
            fragment = new FeedbackFragment();
        }
        else if(id==R.id.nav_aboutus){
            fragment = new AboutUsFragment();
        }
        else if(id==R.id.nav_timetable){
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack("Home");
            ft.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void toast(String toast) {
        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
    }


}
