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
import com.jengasoft.jobalert.ui.adapter.HelpViewPagerAdapter;

/**
 * Created by Mario Anthony Mbinda on 9/13/2017.
 */

public class HelpFragment extends Fragment {
    private TabLayout help_tabLayout;
    private ViewPager help_viewPager;
    private HelpViewPagerAdapter help_viewPagerAdapter;

    public static HelpFragment newInstance(){
        return  new HelpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View helpFragmentView;
        helpFragmentView = inflater.inflate(R.layout.fragment_help, container, false);
        help_tabLayout = (TabLayout) helpFragmentView.findViewById(R.id.help_tabs);
        help_viewPager = (ViewPager) helpFragmentView.findViewById(R.id.help_viewpager);
        help_viewPagerAdapter = new HelpViewPagerAdapter(getFragmentManager());
        help_viewPager.setAdapter(help_viewPagerAdapter);
        final TabLayout.Tab cv_tab = help_tabLayout.newTab();
        final TabLayout.Tab app_letter_tab = help_tabLayout.newTab();
        final TabLayout.Tab mot_letter_tab = help_tabLayout.newTab();

        cv_tab.setText("Curriculum Vitae");
        app_letter_tab.setText("Application Letter");
        mot_letter_tab.setText("Motivation Letter");

        help_tabLayout.addTab(cv_tab, 0);
        help_tabLayout.addTab(app_letter_tab, 1);
        help_tabLayout.addTab(mot_letter_tab, 2);

        help_tabLayout.setTabTextColors(ContextCompat.getColorStateList(getActivity(), R.color.tab_selector));
        help_tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.indicator));
        help_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(help_tabLayout));
        return helpFragmentView;
    }
}
