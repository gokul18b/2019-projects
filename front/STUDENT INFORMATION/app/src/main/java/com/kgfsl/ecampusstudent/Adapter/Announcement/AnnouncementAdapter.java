package com.kgfsl.ecampusstudent.Adapter.Announcement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kgfsl.ecampusstudent.Pojo.Announcement.Announcement;
import com.kgfsl.ecampusstudent.R;


/**
 * Created by gokul on 24-10-2017.
 */

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.Holder> {
    Announcement announcement;
    Context ctx;

    public AnnouncementAdapter(Context context, Announcement announcement) {
        this.announcement = announcement;
        this.ctx = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_row,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return announcement.getAnnouncementdata().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }
}
