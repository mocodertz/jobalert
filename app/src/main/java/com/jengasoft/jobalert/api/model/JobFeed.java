package com.jengasoft.jobalert.api.model;

import com.jengasoft.jobalert.ui.helper.Tag;

import java.util.List;

/**
 * Created by MoCoder#1956# on 9/15/2017.
 */

public class JobFeed {

    private String company_name;
    private String company_logo;
    private String company_slogan;
    private String salary_scale;
    private String deadline_date;
    private String job_type;
    private String job_description;
    private String job_location;
    private List<Tag> category_tags;

    public JobFeed(String company_name, String company_logo, String company_slogan,
                   String salary_scale, String deadline_date, String job_type,
                   String job_description, String job_location, List<Tag> category_tags) {

        this.company_name = company_name;
        this.company_logo = company_logo;
        this.company_slogan = company_slogan;
        this.salary_scale = salary_scale;
        this.deadline_date = deadline_date;
        this.job_type = job_type;
        this.job_description = job_description;
        this.job_location = job_location;
        this.category_tags = category_tags;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public String getCompanyLogo() {
        return company_logo;
    }

    public void setCompanyLogo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getCompanySlogan() {
        return company_slogan;
    }

    public void setCompanySlogan(String company_slogan) {
        this.company_slogan = company_slogan;
    }

    public String getSalaryScale() {
        return salary_scale;
    }

    public void setSalaryScale(String salary_scale) {
        this.salary_scale = salary_scale;
    }

    public String getDeadlineDate() {
        return deadline_date;
    }

    public void setDeadlineDate(String deadline_date) {
        this.deadline_date = deadline_date;
    }

    public String getJobType() {
        return job_type;
    }

    public void setJobType(String job_type) {
        this.job_type = job_type;
    }

    public String getJobDescription() {
        return job_description;
    }

    public void setJobDescription(String job_description) {
        this.job_description = job_description;
    }

    public String getJobLocation() {
        return job_location;
    }

    public void setJobLocation(String job_location) {
        this.job_location = job_location;
    }

    public List<Tag> getCategoryTags() {
        return category_tags;
    }

    public void setCategoryTags(List<Tag> category_tags) {
        this.category_tags = category_tags;
    }

    public boolean hasTag(String string) {
        for (Tag tag : category_tags) {
            if (tag.getText().equals(string)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobFeed)) return false;

        JobFeed jobFeed = (JobFeed) o;

        if (getCompanyLogo() != null ? !getCompanyLogo().equals(jobFeed.getCompanyLogo()) : jobFeed.getCompanyLogo() != null)
            return false;
        if (getCompanyName() != null ? !getCompanyName().equals(jobFeed.getCompanyName()) : jobFeed.getCompanyName() != null)
            return false;
        if (getCompanySlogan() != null ? !getCompanySlogan().equals(jobFeed.getCompanySlogan()) : jobFeed.getCompanySlogan() != null)
            return false;
        if (getSalaryScale() != null ? !getSalaryScale().equals(jobFeed.getSalaryScale()) : jobFeed.getSalaryScale() != null)
            return false;
        if (getJobDescription() != null ? !getJobDescription().equals(jobFeed.getJobDescription()) : jobFeed.getJobDescription() != null)
            return false;
        if (getJobType() != null ? !getJobType().equals(jobFeed.getJobType()) : jobFeed.getJobType() != null)
            return false;
        if (getJobLocation() != null ? !getJobLocation().equals(jobFeed.getJobLocation()) : jobFeed.getJobLocation() != null)
            return false;
        if (getDeadlineDate() != null ? !getDeadlineDate().equals(jobFeed.getDeadlineDate()) : jobFeed.getDeadlineDate() != null)
            return false;
        return getCategoryTags() != null ? getCategoryTags().equals(jobFeed.getCategoryTags()) : jobFeed.getCategoryTags() == null;

    }

    @Override
    public int hashCode() {
        int result = getCompanyLogo() != null ? getCompanyLogo().hashCode() : 0;
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        result = 31 * result + (getCompanySlogan() != null ? getCompanySlogan().hashCode() : 0);
        result = 31 * result + (getSalaryScale() != null ? getSalaryScale().hashCode() : 0);
        result = 31 * result + (getJobDescription() != null ? getJobDescription().hashCode() : 0);
        result = 31 * result + (getJobLocation() != null ? getJobLocation().hashCode() : 0);
        result = 31 * result + (getJobType() != null ? getJobType().hashCode() : 0);
        result = 31 * result + (getCategoryTags() != null ? getCategoryTags().hashCode() : 0);
        return result;
    }
}
