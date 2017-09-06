package com.tian.video.editer.activity;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tian.video.editer.R;
import com.tian.video.editer.fragment.PlaceholderFragment;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;


public class GuideActivity extends AppCompatActivity  {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private int bgColors[];

    private int mCurrentPosition=0;//默认当前的页面为0


    @InjectView(R.id.ib_guide_pre)
    ImageButton preBtn;
    @InjectView(R.id.ib_guide_next)
    ImageButton nextBtn;
    @InjectView(R.id.buttonFinish)
    AppCompatButton buttonFinish;
    @InjectViews({R.id.imageViewIndicator0,R.id.imageViewIndicator1,R.id.imageViewIndicator2})
    List<ImageView> mIndicators;
    @InjectView(R.id.main_content)
    RelativeLayout mMainContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }


        ButterKnife.inject(this);

        bgColors = new int[]{
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.cyan_500),
                ContextCompat.getColor(this, R.color.light_blue_500)};

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabViewPagerChangeListener());

        actionBtn();


    }

    /**
     * 为按钮提供事件处理
     */
    private void actionBtn() {
        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentPosition!=0){
                    mCurrentPosition=mCurrentPosition-1;
                    mViewPager.setCurrentItem(mCurrentPosition);
                }

            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPosition!=2){
                    mCurrentPosition=mCurrentPosition+1;
                    mViewPager.setCurrentItem(mCurrentPosition);
                }
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentPosition==2){
                    //跳转到主界面
                    startActivity(new Intent(GuideActivity.this,MainActivity.class));
                    finish();


                }
            }
        });



    }


    /**
     * ViewPager Page Change Listener
     */
    class TabViewPagerChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int colorUpdate = (Integer) new ArgbEvaluator().evaluate(positionOffset, bgColors[position], bgColors[position == 2 ? position : position + 1]);
            mMainContent.setBackgroundColor(colorUpdate);
        }

        @Override
        public void onPageSelected(int position) {
            mCurrentPosition = position;
            updateIndicators(position);
            mViewPager.setBackgroundColor(bgColors[position]);
            preBtn.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            nextBtn.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
            buttonFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**
     * 刷新圆点选中颜色
     * @param position
     */
    private void updateIndicators(int position) {
        for (int i = 0; i < mIndicators.size(); i++) {
            mIndicators.get(i).setBackgroundResource(
                    i == position ? R.drawable.onboarding_indicator_selected : R.drawable.onboarding_indicator_unselected
            );
        }
    }







    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new PlaceholderFragment(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "one";
                case 1:
                    return "two";
                case 2:
                    return "three";
            }
            return null;
        }
    }






}
