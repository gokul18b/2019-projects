package com.kgfsl.ecampusstudent.Adapter.Gallery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kgfsl.ecampusstudent.Modal.gallery.ImageModel;

import java.util.ArrayList;

/**
 * Created by manivasagam on 06-11-2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public ArrayList<ImageModel> data = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm, ArrayList<ImageModel> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position, data.get(position).getName(), data.get(position).getUrl());
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }
}