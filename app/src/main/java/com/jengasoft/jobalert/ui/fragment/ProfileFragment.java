package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.ui.adapter.ProfileViewPagerAdapter;


/**
 * Created by Mario Anthony Mbinda on 9/13/2017.
 */

public class ProfileFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ProfileViewPagerAdapter profileViewPagerAdapter;

    public static ProfileFragment newInstance(){
        return  new ProfileFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View profileFragmentView;
        profileFragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        tabLayout = (TabLayout) profileFragmentView.findViewById(R.id.profile_tabs);
        viewPager = (ViewPager) profileFragmentView.findViewById(R.id.viewpager);
        profileViewPagerAdapter = new ProfileViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(profileViewPagerAdapter);
        final TabLayout.Tab details_tab = tabLayout.newTab();
        final TabLayout.Tab saved_job_tab = tabLayout.newTab();
        final TabLayout.Tab preference_tab = tabLayout.newTab();

        details_tab.setText("Details");
        saved_job_tab.setText("Saved Job");
        preference_tab.setText("Preferences");

        tabLayout.addTab(details_tab, 0);
        tabLayout.addTab(saved_job_tab, 1);
        tabLayout.addTab(preference_tab, 2);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(getActivity(), R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.indicator));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return profileFragmentView;
    }
}
