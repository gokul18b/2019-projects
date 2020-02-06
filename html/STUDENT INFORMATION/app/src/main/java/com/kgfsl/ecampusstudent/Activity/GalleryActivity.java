package com.kgfsl.ecampusstudent.Activity;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.kgfsl.ecampusstudent.Adapter.Gallery.DepthPageTransformer;
import com.kgfsl.ecampusstudent.Adapter.Gallery.SectionsPagerAdapter;
import com.kgfsl.ecampusstudent.Modal.gallery.ImageModel;
import com.kgfsl.ecampusstudent.R;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    public ArrayList<ImageModel> data = new ArrayList<>();
    int pos;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);



        data = getIntent().getParcelableArrayListExtra("data");
        pos = getIntent().getIntExtra("pos", 0);

//        setTitle(data.get(pos).getName());

        // Create the adapter that will return a fragment for each of the three

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), data);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());

        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(pos);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //noinspection ConstantConditions
                setTitle(data.get(position).getName());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }





}
