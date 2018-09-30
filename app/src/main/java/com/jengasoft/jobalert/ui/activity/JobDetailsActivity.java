package com.jengasoft.jobalert.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.api.model.ListItem;
import com.jengasoft.jobalert.ui.adapter.CommonViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MoCoder#1956# on 9/27/2017.
 */

public class JobDetailsActivity extends AppCompatActivity {
    private Toolbar job_details_toolbar;
    private AppCompatImageView jobDetailsSimpleDraweeView;

    private RecyclerView responsibilitiesListRecyclerView;
    private CommonViewAdapter responsibilitiesCommonViewAdapter;
    private List<ListItem> responsibilitiesList;

    private CommonViewAdapter skillsCommonViewAdapter;
    private List<ListItem> skillsList;
    private RecyclerView skillsListRecyclerView;

    private CommonViewAdapter academicRequirementCommonViewAdapter;
    private List<ListItem> academicRequirementList;
    private RecyclerView academicRequirementListRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        job_details_toolbar = (Toolbar) findViewById(R.id.job_details_toolbar);
        job_details_toolbar.setTitle("Job Details");
        getSupportActionBar();

        jobDetailsSimpleDraweeView = (AppCompatImageView) findViewById(R.id.details_company_logo);
        Glide.with(this).load("https://newsroom.mastercard.com/mea/files/2015/06/nmb.jpg").into(jobDetailsSimpleDraweeView);

        /**
         * Setting Responsibilities List RecyclerView
         * */
        responsibilitiesListRecyclerView = (RecyclerView) findViewById(
                R.id.job_details_duties_resp_list);
        responsibilitiesListRecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));
        responsibilitiesListRecyclerView.setAdapter(
                responsibilitiesCommonViewAdapter = new CommonViewAdapter(
                        responsibilitiesList = getResponsibilitiesList(), this));

        /**
         * Setting Skills and Experience List RecyclerView
         * */
        skillsListRecyclerView = (RecyclerView) findViewById(
                R.id.details_job_skills_experience_list);
        skillsListRecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));
        skillsListRecyclerView.setAdapter(
                skillsCommonViewAdapter = new CommonViewAdapter(
                        skillsList = getSkillsList(), this));

        /**
         * Setting Academic Requirement List RecyclerView
         * */
        academicRequirementListRecyclerView = (RecyclerView) findViewById(
                R.id.details_job_edu_req_list);
        academicRequirementListRecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));
        academicRequirementListRecyclerView.setAdapter(
                academicRequirementCommonViewAdapter = new CommonViewAdapter(
                        skillsList = getAcademicsList(), this));
    }

    private List<ListItem> getResponsibilitiesList() {
        return new ArrayList<ListItem>() {{
            add(new ListItem("Provide analysis related to software design and development and solve problems."));
            add(new ListItem("Formulate systems advancements; perform improvements to support user friendly interfaces and usability aides to assist users understand their operations on the system environment"));
            add(new ListItem("Appraise business systems performance and provide appropriate recommendations."));
            add(new ListItem("Prepare business system data for internal and external auditing when requested"));
        }};
    }

    private List<ListItem> getSkillsList() {
        return new ArrayList<ListItem>() {{
            add(new ListItem("Knowledge and experience in .Net Framework, Development of web based applications, Software Development platforms plus certification in Information Technology will be an added advantage"));
            add(new ListItem("At least three (3) years of relevant working experience from a recognized institution"));
        }};
    }

    private List<ListItem> getAcademicsList() {
        return new ArrayList<ListItem>() {{
            add(new ListItem("Bachelor Degree in Computer Science from accredited academic institutions."));
            add(new ListItem("Advanced Diploma in Computer Science from accredited academic institutions."));
            add(new ListItem("Certificate in Computer Science from accredited academic institutions."));
        }};
    }
}
