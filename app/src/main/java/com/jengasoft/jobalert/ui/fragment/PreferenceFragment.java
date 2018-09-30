package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jengasoft.jobalert.R;

/**
 * Created by MoCoder#1956# on 9/19/2017.
 */

public class PreferenceFragment  extends Fragment {

    public static PreferenceFragment newInstance() {
        return new PreferenceFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View preferenceFragmentView;
        preferenceFragmentView = inflater.inflate(R.layout.fragment_preference, container, false);
        return preferenceFragmentView;
    }
}
