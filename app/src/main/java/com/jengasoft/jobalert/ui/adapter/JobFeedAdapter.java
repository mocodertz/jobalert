package com.jengasoft.jobalert.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;
import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.api.model.JobFeed;
import com.jengasoft.jobalert.ui.activity.JobDetailsActivity;
import com.jengasoft.jobalert.ui.activity.MainActivity;
import com.jengasoft.jobalert.ui.helper.Tag;

import java.util.List;

/**
 * Created by MoCoder#1956# on 9/15/2017.
 */

public class JobFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JobFeed> jobFeedList;
    private Context mainContext;

    private static final int DEFAULT_VIEW_TYPE = 1;
    private static final int NATIVE_AD_VIEW_TYPE = 2;

    public JobFeedAdapter(List<JobFeed> jobFeedList, Context mainContext) {
        this.jobFeedList = jobFeedList;
        this.mainContext = mainContext;
    }

    public List<JobFeed> getJobFeedList() {
        return jobFeedList;
    }

    public void setJobFeedList(List<JobFeed> jobFeedList) {
        this.jobFeedList = jobFeedList;
    }

    private int getColor(int color) {
        return ContextCompat.getColor(mainContext, color);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(mainContext);
        switch (viewType) {
            default:
                view = layoutInflater
                        .inflate(R.layout.job_feed_item_view, parent, false);
                return new ItemViewHolder(view);

            case NATIVE_AD_VIEW_TYPE:
                view = layoutInflater.inflate(R.layout.list_item_native_ad, parent, false);
                return new NativeAdViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position > 1 && position % 3 == 0) {
            return NATIVE_AD_VIEW_TYPE;
        }
        return DEFAULT_VIEW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (!(holder instanceof ItemViewHolder)) {
            return;
        }
        JobFeed jobFeed = jobFeedList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.company_logo.setImageURI(jobFeed.getCompanyLogo());
        itemViewHolder.company_name.setText(jobFeed.getCompanyName());
        itemViewHolder.company_slogan.setText(jobFeed.getCompanySlogan());
        itemViewHolder.salary_scale.setText(jobFeed.getSalaryScale());
        itemViewHolder.job_description.setText(jobFeed.getJobDescription());
        itemViewHolder.job_type.setText(jobFeed.getJobType());
        Tag firstTag = jobFeed.getCategoryTags().get(0);
        itemViewHolder.firstFilter.setText(firstTag.getText());
        Tag secondTag = jobFeed.getCategoryTags().get(1);
        itemViewHolder.secondFilter.setText(secondTag.getText());

        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(100);
        drawable.setColor(firstTag.getColor());
        itemViewHolder.firstFilter.setBackgroundDrawable(drawable);
        GradientDrawable drawable1 = new GradientDrawable();
        drawable1.setCornerRadius(100);
        drawable1.setColor(secondTag.getColor());
        itemViewHolder.secondFilter.setBackgroundDrawable(drawable1);

    }

    @Override
    public int getItemCount() {
        return jobFeedList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView company_name;
        TextView company_slogan;
        TextView salary_scale;
        TextView job_description;
        TextView job_type;
        TextView job_location;
        TextView job_deadline_date;
        TextView firstFilter;
        TextView secondFilter;
        SimpleDraweeView company_logo;

        public ItemViewHolder(View itemView) {
            super(itemView);

            company_name = (TextView) itemView.findViewById(R.id.company_name);
            company_slogan = (TextView) itemView.findViewById(R.id.company_slogan);
            salary_scale = (TextView) itemView.findViewById(R.id.job_salary_scale);
            job_description = (TextView) itemView.findViewById(R.id.job_description);
            job_type = (TextView) itemView.findViewById(R.id.job_type);
            job_location = (TextView) itemView.findViewById(R.id.job_location);
            job_deadline_date = (TextView) itemView.findViewById(R.id.job_deadline);
            firstFilter = (TextView) itemView.findViewById(R.id.filter_first);
            secondFilter = (TextView) itemView.findViewById(R.id.filter_second);
            company_logo = (SimpleDraweeView) itemView.findViewById(R.id.company_logo);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //int pos = getLayoutPosition();
                    //Toast.makeText(mainContext,pos , Toast.LENGTH_SHORT).show();
                    Intent jobDetails = new Intent(mainContext, JobDetailsActivity.class);
                    mainContext.startActivity(jobDetails);
                }
            });
        }
    }

    public class NativeAdViewHolder extends RecyclerView.ViewHolder {

        private final NativeExpressAdView mNativeAd;
        //private final AdView adView;
        

        public NativeAdViewHolder(View itemView) {
            super(itemView);
            mNativeAd = (NativeExpressAdView) itemView.findViewById(R.id.job_feed_nativeAd);
            //adView = (AdView) itemView.findViewById(R.id.job_feed_adView);

            /*mNativeAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                }

                @Override
                public void onAdLeftApplication() {
                    super.onAdLeftApplication();
                }

                @Override
                public void onAdOpened() {
                    super.onAdOpened();
                }
            });*/
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(MainActivity.TEST_DEVICE_ID)
                    .build();
            //You can add the following code if you are testing in an emulator
            //AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.build();
            mNativeAd.loadAd(adRequest);
            //adView.loadAd(adRequest);
        }
    }

}

