package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jengasoft.jobalert.R;

/**
 * Created by MoCoder#1956# on 10/4/2017.
 */

public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    int[] bgs = new int[]{R.drawable.logo, R.drawable.sample, R.drawable.ic_account_box_black_24dp};

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_on_boardingctivity, container, false);
        AppCompatTextView description_text = (AppCompatTextView) rootView.findViewById(R.id.description_text);
        AppCompatImageView section_image = (AppCompatImageView) rootView.findViewById(R.id.section_img);

        description_text.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        section_image.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
        return rootView;
    }
}