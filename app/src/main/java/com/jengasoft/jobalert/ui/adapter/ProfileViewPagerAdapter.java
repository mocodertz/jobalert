package com.jengasoft.jobalert.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jengasoft.jobalert.ui.fragment.ApplicationLetterFragment;
import com.jengasoft.jobalert.ui.fragment.PreferenceFragment;
import com.jengasoft.jobalert.ui.fragment.SavedJobFragment;
import com.jengasoft.jobalert.ui.fragment.UserDetailsFragment;

/**
 * Created by MoCoder#1956# on 9/19/2017.
 */

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {

    public ProfileViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new UserDetailsFragment();
            case 1:
                return new SavedJobFragment();
            case 2:
                return new PreferenceFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
