package com.jengasoft.jobalert.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jengasoft.jobalert.ui.fragment.ApplicationLetterFragment;
import com.jengasoft.jobalert.ui.fragment.CurriculumVitaeFragment;
import com.jengasoft.jobalert.ui.fragment.MotivationLetterFragment;
import com.jengasoft.jobalert.ui.fragment.PreferenceFragment;

/**
 * Created by MoCoder#1956# on 9/19/2017.
 */

public class HelpViewPagerAdapter extends FragmentStatePagerAdapter {

    public HelpViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CurriculumVitaeFragment();
            case 1:
                return new ApplicationLetterFragment();
            case 2:
                return new MotivationLetterFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
