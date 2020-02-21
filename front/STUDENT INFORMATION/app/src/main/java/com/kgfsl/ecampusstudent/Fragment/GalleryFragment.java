package com.kgfsl.ecampusstudent.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kgfsl.ecampusstudent.Activity.GalleryActivity;
import com.kgfsl.ecampusstudent.Adapter.Gallery.GalleryAdapter;
import com.kgfsl.ecampusstudent.Modal.gallery.ImageModel;
import com.kgfsl.ecampusstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gokul on 06-11-2017.
 */

public class GalleryFragment extends Fragment {
    View v;
    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList<ImageModel> data = new ArrayList<>();
    public static Integer IMGS[] = {
            R.drawable.gallery1,
            R.drawable.gallery2, R.drawable.gallery3,R.drawable.gallery4,R.drawable.gallery5,R.drawable.gallery6,R.drawable.gallery7,R.drawable.gallery8,R.drawable.gallery9
    };

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_gallery, container, false);

        getImages();
        return v;
    }

    private void getImages() {
        for (int i = 0; i < IMGS.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName("Image " + i);
            imageModel.setUrl(IMGS[i]);
            data.add(imageModel);

        }
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(v.getContext(), 3));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new GalleryAdapter(v.getContext(), data, new GalleryAdapter.OnclickListner() {
            @Override
            public void imageClickListner(List<ImageModel> data1, int position) {
                Intent intent = new Intent(v.getContext(), GalleryActivity.class);
                intent.putParcelableArrayListExtra("data", data);
                intent.putExtra("pos", position);
                v.getContext().startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }
}
