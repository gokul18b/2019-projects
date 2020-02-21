package com.kgfsl.ecampusstudent.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgfsl.ecampusstudent.Adapter.Announcement.AnnouncementAdapter;
import com.kgfsl.ecampusstudent.Pojo.Announcement.Announcement;
import com.kgfsl.ecampusstudent.R;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnnouncementFragment extends Fragment {

    RecyclerView recyclerView;
    View v;
    public AnnouncementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_announcement, container, false);
        Initialize();
        return v;
    }

    private void Initialize() {
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        getAnnouncement();

    }

    private void getAnnouncement() {
        String json ="{\"status\":true,\"announcementdata\":[{\"img\":\"\",\"des\":\"Test 1\",\"link\":\"www.google.com\"},{\"img\":\"\",\"des\":\"Test 2\",\"link\":\"www.google.com\"},{\"img\":\"\",\"des\":\"Test 3\",\"link\":\"www.google.com\"},{\"img\":\"\",\"des\":\"Test 4\",\"link\":\"www.google.com\"}]}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Announcement announcement = objectMapper.readValue(json,Announcement.class);
            AnnouncementAdapter announcementAdapter = new AnnouncementAdapter(v.getContext(),announcement);
            recyclerView.setAdapter(announcementAdapter);
        } catch (IOException e) {
            e.printStackTrace();
            toast(e.toString());
        }

    }

    private void toast(String toast) {
        Toast.makeText(v.getContext(),toast,Toast.LENGTH_SHORT).show();
    }


}
