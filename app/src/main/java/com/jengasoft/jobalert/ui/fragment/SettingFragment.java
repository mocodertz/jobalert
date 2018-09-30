package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jengasoft.jobalert.R;

/**
 * Created by Mario Anthony Mbinda on 9/13/2017.
 */

public class SettingFragment extends Fragment {
    public static SettingFragment newInstance(){
        return  new SettingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

}
