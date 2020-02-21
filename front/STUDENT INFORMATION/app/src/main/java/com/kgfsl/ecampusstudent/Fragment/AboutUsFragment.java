package com.kgfsl.ecampusstudent.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kgfsl.ecampusstudent.Adapter.AboutUs.ImageSlideAdapter;
import com.kgfsl.ecampusstudent.Modal.about.CirclePageIndicator;
import com.kgfsl.ecampusstudent.Modal.about.ImagesModal;
import com.kgfsl.ecampusstudent.Modal.about.JsonReader;
import com.kgfsl.ecampusstudent.Modal.about.PageIndicator;
import com.kgfsl.ecampusstudent.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {

    public static final String ARG_ITEM_ID = "home_fragment";

    private static final long ANIM_VIEWPAGER_DELAY = 5000;
    private static final long ANIM_VIEWPAGER_DELAY_USER_VIEW = 10000;

    private ViewPager mViewPager;
    TextView imgNameTxt;
    PageIndicator mIndicator;
    List<ImagesModal> ImagesModal;
    boolean stopSliding = false;
    private Runnable animateViewPager;
    private Handler handler;
    FragmentActivity activity;
    View view;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about_us, container, false);
        findViewBYID();
        Listner();
        return view;
    }

    private void findViewBYID() {
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        imgNameTxt = (TextView) view.findViewById(R.id.img_name);
    }

    private void Listner() {
        mIndicator.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setOnPageChangeListener(new PageChangeListener());
        mViewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction()) {

                    case MotionEvent.ACTION_CANCEL:
                        break;

                    case MotionEvent.ACTION_UP:

                        if (ImagesModal != null && ImagesModal.size() != 0) {
                            stopSliding = false;
                            runnable(ImagesModal.size());
                            handler.postDelayed(animateViewPager,
                                    ANIM_VIEWPAGER_DELAY_USER_VIEW);
                        }
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if (handler != null && stopSliding == false) {
                            stopSliding = true;
                            handler.removeCallbacks(animateViewPager);
                        }
                        break;
                }
                return false;
            }
        });
    }

    public void runnable(final int size) {
        handler = new Handler();
        animateViewPager = new Runnable() {
            public void run() {
                if (!stopSliding) {
                    if (mViewPager.getCurrentItem() == size - 1) {
                        mViewPager.setCurrentItem(0);
                    } else {
                        mViewPager.setCurrentItem(
                                mViewPager.getCurrentItem() + 1, true);
                    }
                    handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
                }
            }
        };
    }

    @Override
    public void onResume() {
        if (ImagesModal == null) {
            sendRequest();
        } else {
            mViewPager.setAdapter(new ImageSlideAdapter(activity, ImagesModal,
                    view.getContext()));

            mIndicator.setViewPager(mViewPager);
            imgNameTxt.setText(""
                    + ((ImagesModal) ImagesModal.get(mViewPager.getCurrentItem()))
                    .getName());
            runnable(ImagesModal.size());
            //Re-run callback
            handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
        }
        super.onResume();
    }


    private void sendRequest() {

        String json = "{\"status\":true,\"data\":{\"products\":[{\"id\":\"434\",\"name\":\"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\",\"image_url\":\"http://www.kgcas.ac.in/images/banner1.jpg\"},{\"id\":\"431\",\"name\":\"XXXXXXXXXX XXXXX XXXXXXXXX\",\"image_url\":\"http://www.kgcas.ac.in/images/banner2.jpg\"},{\"id\":\"424\",\"name\":\"XXXXXXXXXXXXXXXXXXX\",\"image_url\":\"http://www.kgcas.ac.in/images/banner3.jpg\"},{\"id\":\"426\",\"name\":\"XXXXXXXXXXXXXX\",\"image_url\":\"http://www.kgcas.ac.in/images/banner5.jpg\"},{\"id\":\"419\",\"name\":\"XXXXXX\",\"image_url\":\"http://www.kgcas.ac.in/images/banner5.jpg\"},{\"id\":\"419\",\"name\":\"XXXXXXXXXXXXXXXXXXXX\",\"image_url\":\"http://www.kgcas.ac.in/images/banner6.jpg\"},{\"id\":\"419\",\"name\":\"XXXXXXXXXXXXXXXXXXXXx\",\"image_url\":\"http://www.kgcas.ac.in/images/banner7.jpg\"}]}}";
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            List<ImagesModal>  result= JsonReader.getHome(jsonObject1);
            ImagesModal = result;
            if (result != null) {

                if (ImagesModal != null && ImagesModal.size() != 0) {

                    mViewPager.setAdapter(new ImageSlideAdapter(
                            activity, ImagesModal, view.getContext()));

                    mIndicator.setViewPager(mViewPager);
                    imgNameTxt.setText(""
                            + ((ImagesModal) ImagesModal.get(mViewPager
                            .getCurrentItem())).getName());
                    runnable(ImagesModal.size());
                    handler.postDelayed(animateViewPager,
                            ANIM_VIEWPAGER_DELAY);
                } else {
                    imgNameTxt.setText("No Products");
                }
            } else {
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                if (ImagesModal != null) {
                    imgNameTxt.setText(""
                            + ((ImagesModal) ImagesModal.get(mViewPager
                            .getCurrentItem())).getName());
                }
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
