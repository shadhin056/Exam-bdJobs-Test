package com.fundinghelp.moniruzzamanshadhinapplication.model;

import com.google.gson.annotations.SerializedName;

public class JobDetails {

    @SerializedName("jobTitle")
    private String jobTitle;

    @SerializedName("deadline")
    private String deadline;

    @SerializedName("recruitingCompany'sProfile")
    private String recruitingCompanySProfile;

    @SerializedName("jobDetails")
    private JobsDate jobsDate;

    @SerializedName("logo")
    private String logo;

    @SerializedName("IsFeatured")
    private boolean isFeatured;

    @SerializedName("minExperience")
    private Object minExperience;

    @SerializedName("maxExperience")
    private int maxExperience;

    @SerializedName("minSalary")
    private String minSalary;

    @SerializedName("maxSalary")
    private String maxSalary;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getRecruitingCompanySProfile() {
        return recruitingCompanySProfile;
    }

    public void setRecruitingCompanySProfile(String recruitingCompanySProfile) {
        this.recruitingCompanySProfile = recruitingCompanySProfile;
    }

    public JobsDate getJobsDate() {
        return jobsDate;
    }

    public void setJobsDate(JobsDate jobsDate) {
        this.jobsDate = jobsDate;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Object getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(Object minExperience) {
        this.minExperience = minExperience;
    }

    public int getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

}
