package com.jengasoft.jobalert.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.api.model.JobFeed;
import com.jengasoft.jobalert.ui.adapter.JobFeedAdapter;
import com.jengasoft.jobalert.ui.helper.Tag;
import com.yalantis.filter.adapter.FilterAdapter;
import com.yalantis.filter.animator.FiltersListItemAnimator;
import com.yalantis.filter.listener.FilterListener;
import com.yalantis.filter.widget.Filter;
import com.yalantis.filter.widget.FilterItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario Anthony Mbinda on 9/13/2017.
 */

public class FeedFragment extends Fragment implements FilterListener<Tag> {
    private RecyclerView recyclerView;
    private int[] mColors;
    private String[] mTitles;
    private List<JobFeed> jobFeedList;
    private Filter<Tag> mFilter;
    private JobFeedAdapter jobFeedAdapter;

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View feedFragmentView;
        feedFragmentView = inflater.inflate(R.layout.fragment_feed, container, false);
        ImagePipelineConfig config = ImagePipelineConfig
                .newBuilder(getActivity())
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(getActivity(), config);

        mColors = getResources().getIntArray(R.array.colors);
        mTitles = getResources().getStringArray(R.array.job_titles);

        mFilter = (Filter<Tag>) feedFragmentView.findViewById(R.id.filter);
        mFilter.setAdapter(new Adapter(getTags()));
        mFilter.setListener(this);

        //the text to show when there's no selected items
        mFilter.setNoSelectedItemText(getString(R.string.str_all_selected));
        mFilter.build();


        recyclerView = (RecyclerView) feedFragmentView.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(jobFeedAdapter = new JobFeedAdapter(jobFeedList = getJobFeedList(), getActivity()));
        recyclerView.setItemAnimator(new FiltersListItemAnimator());
        return feedFragmentView;
    }

    private void calculateDiff(final List<JobFeed> oldList, final List<JobFeed> newList) {
        DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return oldList.size();
            }

            @Override
            public int getNewListSize() {
                return newList.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
            }
        }).dispatchUpdatesTo(jobFeedAdapter);
    }

    private List<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();

        for (int i = 0; i < mTitles.length; ++i) {
            tags.add(new Tag(mTitles[i], mColors[i]));
        }

        return tags;
    }

    @Override
    public void onFiltersSelected(@NotNull ArrayList<Tag> filters) {
        List<JobFeed> newQuestions = findByTags(filters);
        List<JobFeed> oldQuestions = jobFeedAdapter.getJobFeedList();
        jobFeedAdapter.setJobFeedList(newQuestions);
        calculateDiff(oldQuestions, newQuestions);
    }

    @Override
    public void onNothingSelected() {
        if (recyclerView != null) {
            jobFeedAdapter.setJobFeedList(jobFeedList);
            jobFeedAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFilterSelected(Tag item) {
        if (item.getText().equals(mTitles[0])) {
            mFilter.deselectAll();
            mFilter.collapse();
        }
    }

    class Adapter extends FilterAdapter<Tag> {

        Adapter(@NotNull List<? extends Tag> items) {
            super(items);
        }

        @NotNull
        @Override
        public FilterItem createView(int position, Tag item) {
            FilterItem filterItem = new FilterItem(getActivity());

            filterItem.setStrokeColor(mColors[0]);
            filterItem.setTextColor(mColors[0]);
            filterItem.setCornerRadius(100);
            filterItem.setCheckedTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));
            filterItem.setColor(ContextCompat.getColor(getActivity(), android.R.color.white));
            filterItem.setCheckedColor(mColors[position]);
            filterItem.setText(item.getText());
            filterItem.deselect();

            return filterItem;
        }
    }

    @Override
    public void onFilterDeselected(Tag tag) {

    }

    private List<JobFeed> findByTags(List<Tag> tags) {
        List<JobFeed> questions = new ArrayList<>();

        for (JobFeed jobFeed : jobFeedList) {
            for (Tag tag : tags) {
                if (jobFeed.hasTag(tag.getText()) && !questions.contains(jobFeed)) {
                    questions.add(jobFeed);
                }
            }
        }

        return questions;
    }

    /**
     * Sample Data
     */
    private List<JobFeed> getJobFeedList() {

        ArrayList<JobFeed> jobFeedData = new ArrayList<JobFeed>() {{
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
                    "https://i.pinimg.com/originals/d0/54/89/d054890aa6a20fe5273d24feff7acc79.jpg",
                    "Good Service For Everyone", "₹10k - ₹500k",
                    "2017-9-30", "Full Time",
                    "Our products help people in their everyday life, helping them to perform better at work or school, or have better relationships and in general have better quality of life.",
                    "Kisutu, Arusha", new ArrayList<Tag>() {{
                add(new Tag(mTitles[1], mColors[1]));
                add(new Tag(mTitles[3], mColors[3]));
            }}));
        }};

        for (int i = 0; i < jobFeedData.size(); i++) {
            if (i > 0 && i % 3 == 0) {
                //This is dummy movie that will be added in every 3rd position of the list
                //As Native ads will be displayed in every 3rd position we cant have our Movies in 3rd pos
                jobFeedData.add(i, new JobFeed("Msemakweli Company",
                        "https://i.pinimg.com/originals/d0/54/89/d054890aa6a20fe5273d24feff7acc79.jpg",
                        "Good Service For Everyone", "₹10k - ₹500k",
                        "2017-9-30", "Full Time",
                        "Our products help people in their everyday life, helping them to perform better at work or school, or have better relationships and in general have better quality of life.",
                        "Kisutu, Arusha", new ArrayList<Tag>() {{
                    add(new Tag(mTitles[1], mColors[1]));
                    add(new Tag(mTitles[3], mColors[3]));
                }}));
                //Or you can add a null value instead of dummy movie
                //listOfMovies.add(i,null);
            }
        }
        return jobFeedData;
    }
}
