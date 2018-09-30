package com.jengasoft.jobalert.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.ui.adapter.SectionsPagerAdapter;

public class OnBoardingActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private AppCompatImageView indicator_zero, indicator_one, indicator_two;
    private AppCompatImageView[] indicators;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        /**
         * Indicator for Each ViewPager Section
         * */
        indicator_zero = (AppCompatImageView) findViewById(R.id.intro_indicator_0);
        indicator_one = (AppCompatImageView) findViewById(R.id.intro_indicator_1);
        indicator_two = (AppCompatImageView) findViewById(R.id.intro_indicator_2);

        indicators = new AppCompatImageView[]{indicator_zero, indicator_one, indicator_two};
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                updateIndicators(page);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void updateIndicators(int position) {

        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i == position ? R.drawable.indicator_selected : R.drawable.indicator_unselected
            );
        }
    }
}
