package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jengasoft.jobalert.R;

/**
 * Created by MoCoder#1956# on 9/19/2017.
 */

public class UserDetailsFragment extends Fragment {
    private SimpleDraweeView userProfilePhoto;
    public static UserDetailsFragment newInstance(){
        return  new UserDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View userDetailsFragmentView;
        userDetailsFragmentView = inflater.inflate(R.layout.fragment_user_details, container, false);

        userProfilePhoto = (SimpleDraweeView)userDetailsFragmentView.findViewById(R.id.user_profile_photo);
        userProfilePhoto.setImageURI("https://lh3.googleusercontent.com/-9T0f57Nz-A0/AAAAAAAAAAI/AAAAAAAAAAA/ACnBePYZp8j68aBU2mmW9b9mFA1qyfwKlw/mo/photo.jpg?sz=46");
        return userDetailsFragmentView;
    }
}

