package com.kgfsl.ecampusstudent.Adapter.Gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kgfsl.ecampusstudent.Modal.gallery.ImageModel;
import com.kgfsl.ecampusstudent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gokul on 06-11-2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    Context context;
    List<ImageModel> data = new ArrayList<>();
    final OnclickListner onclickListner;

    public GalleryAdapter(Context context, List<ImageModel> data,OnclickListner onclickListner) {
        this.context = context;
        this.data = data;
        this.onclickListner =onclickListner;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row_gallery, parent, false);
        viewHolder = new MyItemHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

//        Glide.with(context).load(data.get(position).getUrl())
//                .thumbnail(0.5f)
//                .override(200,200)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(((MyItemHolder) holder).mImg);
        ((MyItemHolder) holder).mImg.setImageResource(data.get(position).getUrl());
        ((MyItemHolder) holder).bind(data,onclickListner,position);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class MyItemHolder extends RecyclerView.ViewHolder {
        ImageView mImg;


        public MyItemHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.item_img);

        }

        public void bind(final List<ImageModel> data, final OnclickListner onclickListner, final int position) {
            mImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickListner.imageClickListner(data,position);
                }
            });
        }
    }

    public interface OnclickListner{
        void imageClickListner(List<ImageModel> data, int position);
    }

}
