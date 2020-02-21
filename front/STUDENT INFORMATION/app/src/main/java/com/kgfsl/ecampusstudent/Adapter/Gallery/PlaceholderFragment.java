package com.kgfsl.ecampusstudent.Adapter.Gallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kgfsl.ecampusstudent.R;

/**
 * Created by manivasagam on 06-11-2017.
 */

public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    String name;
    Integer url;
    int pos;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_IMG_TITLE = "image_title";
    private static final String ARG_IMG_URL = "image_url";

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.pos = args.getInt(ARG_SECTION_NUMBER);
        this.name = args.getString(ARG_IMG_TITLE);
        this.url = args.getInt(ARG_IMG_URL);
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber, String name, Integer url) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putString(ARG_IMG_TITLE, name);
        args.putInt(ARG_IMG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallerydetail, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.detail_image);

        //  Glide.with(getActivity()).load(url).thumbnail(0.1f).into(imageView);
        imageView.setImageResource(url);

        return rootView;
    }

}