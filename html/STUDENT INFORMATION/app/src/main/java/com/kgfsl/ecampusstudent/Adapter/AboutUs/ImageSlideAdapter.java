package com.kgfsl.ecampusstudent.Adapter.AboutUs;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kgfsl.ecampusstudent.Modal.about.ImagesModal;
import com.kgfsl.ecampusstudent.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by manivasagam on 08-11-2017.
 */

public class ImageSlideAdapter extends PagerAdapter {

    FragmentActivity activity;
    List<ImagesModal> ImagesModal;

    Context ctx;

    public ImageSlideAdapter(FragmentActivity activity, List<ImagesModal> ImagesModal,
                             Context ctx) {
        this.ctx=activity;
        this.activity = activity;
        this.ctx=ctx;
        this.ImagesModal = ImagesModal;



    }

    @Override
    public int getCount() {
        return ImagesModal.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, final int position) {




            View view = LayoutInflater.from(container.getContext()).inflate(R.layout.aboutus_image, container, false);

            ImageView mImageView = (ImageView) view
                    .findViewById(R.id.image_display);


            mImageView.setImageResource(R.drawable.ic_action_gallery);
        Picasso.with(view.getContext())
                .load(((ImagesModal) ImagesModal.get(position)).getImageUrl())
                .fit()
                .into(mImageView);
            container.addView(view);

            return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
