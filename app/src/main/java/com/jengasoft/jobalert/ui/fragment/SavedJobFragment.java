package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.api.model.JobFeed;
import com.jengasoft.jobalert.ui.adapter.JobFeedAdapter;
import com.jengasoft.jobalert.ui.helper.Tag;
import com.yalantis.filter.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoCoder#1956# on 9/21/2017.
 */

public class SavedJobFragment extends Fragment {
    private RecyclerView recyclerView;
    private int[] mColors;
    private String[] mTitles;
    private List<JobFeed> jobFeedList;
    private Filter<Tag> mFilter;
    private JobFeedAdapter jobFeedAdapter;


    public static SavedJobFragment newInstance(){
        return  new SavedJobFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View savedJobFragmentView;
        savedJobFragmentView = inflater.inflate(R.layout.fragment_saved_job, container, false);
        mColors = getResources().getIntArray(R.array.colors);
        mTitles = getResources().getStringArray(R.array.job_titles);

        recyclerView = (RecyclerView)savedJobFragmentView.findViewById(R.id.job_saved_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(jobFeedAdapter = new JobFeedAdapter(jobFeedList = getJobFeedList(), getActivity()));
        return savedJobFragmentView;
    }

    private List<JobFeed> getJobFeedList() {
        return new ArrayList<JobFeed>() {{
            add(new JobFeed("JengaSoft Company",
                    "https://i.pinimg.com/originals/5b/2d/bb/5b2dbbc4c2f3b7db7cad60cd89997e30.jpg",
                    "We Build Better Software For You",
                    "₹10k - ₹500k",
                    "2017-9-30", "Full Time",
                    "Our products help people in their everyday life, helping them to perform better at work or school, or have better relationships and in general have better quality of life. We use our expertise in the science of Psychology, and help users maintain their privacy.",
                    "Kisutu, Arusha", new ArrayList<Tag>() {{
                add(new Tag(mTitles[2], mColors[2]));
                add(new Tag(mTitles[4], mColors[4]));
            }}));

            add(new JobFeed("JengaSoft Company",
                    "http://www.underconsideration.com/brandnew/archives/dell_2016_logo.png",
                    "We Build Better Software For You",
                    "₹10k - ₹500k",
                    "2017-9-30", "Full Time",
                    "Our products help people in their everyday life, helping them to perform better at work or school, or have better relationships and in general have better quality of life. We use our expertise in the science of Psychology, and help users maintain their privacy. Our product helps overcome some of the biggest barriers to approaching counselors, i.e. stigma and lack of access.",
                    "Kisutu, Arusha", new ArrayList<Tag>() {{
                add(new Tag(mTitles[2], mColors[2]));
                add(new Tag(mTitles[4], mColors[4]));
            }}));

            add(new JobFeed("John Shop Company",
                    "https://i.pinimg.com/originals/d0/54/89/d054890aa6a20fe5273d24feff7acc79.jpg", "₹10k - ₹500k",
                    "Get Quality Product",
                    "2017-9-30", "Full Time",
                    "Our products help people in their everyday life, helping them to perform better at work or school, or have better relationships and in general have better quality of life. We use our expertise in the science of Psychology, and help users maintain their privacy. Our product helps overcome some of the biggest barriers to approaching counselors, i.e. stigma and lack of access.",
                    "Kisutu, Arusha", new ArrayList<Tag>() {{
                add(new Tag(mTitles[3], mColors[3]));
                add(new Tag(mTitles[5], mColors[5]));
            }}));

            add(new JobFeed("Msemakweli Company",
                    "https://i.pinimg.com/originals/d0/54/89/d054890aa6a20fe5273d24feff7acc79.jpg"
                    , "₹10k - ₹500k",
                    "Good Service For Everyone",
                    "2017-9-30", "Full Time",
                    "Our products help people in their everyday life, helping them to perform better at work or school, or have better relationships and in general have better quality of life.",
                    "Kisutu, Arusha", new ArrayList<Tag>() {{
                add(new Tag(mTitles[1], mColors[1]));
                add(new Tag(mTitles[3], mColors[3]));
            }}));
        }};
    }
}
