package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.api.model.Document;
import com.jengasoft.jobalert.ui.adapter.DocumentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoCoder#1956# on 9/20/2017.
 */

public class ApplicationLetterFragment extends Fragment {
    private RecyclerView sample_application_letter;
    private DocumentAdapter documentAdapter;
    private List<Document> documentList;
    private AdView adView;

    public static ApplicationLetterFragment newInstance() {
        return new ApplicationLetterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View applicationLetterFragmentView;
        applicationLetterFragmentView = inflater.inflate(R.layout.fragment_application_letter, container, false);
        sample_application_letter = (RecyclerView) applicationLetterFragmentView.findViewById(R.id.sample_application_letter_list);
        sample_application_letter.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        sample_application_letter.setAdapter(documentAdapter = new DocumentAdapter(documentList = getDocumentList(), getActivity()));

        adView = (AdView) applicationLetterFragmentView.findViewById(R.id.job_feed_adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        return applicationLetterFragmentView;
    }

    private List<Document> getDocumentList() {
        return new ArrayList<Document>() {{
            add(new Document("Experienced", "HHH", "http://kingofwallpapers.com/girl/girl-011.jpg"));
            add(new Document("Senior", "HHH", "http://kingofwallpapers.com/girl/girl-011.jpg"));
            add(new Document("Junior", "HHH", "http://kingofwallpapers.com/girl/girl-011.jpg"));
            add(new Document("Graduate", "HHH", "http://kingofwallpapers.com/girl/girl-011.jpg"));

        }};
    }

}
