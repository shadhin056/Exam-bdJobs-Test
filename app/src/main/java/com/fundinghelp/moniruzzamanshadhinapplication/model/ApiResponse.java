package com.fundinghelp.moniruzzamanshadhinapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("statuscode")
    private String statuscode;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<JobDetails> jobs = null;

    @SerializedName("common")
    private Page page;

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<JobDetails> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobDetails> jobs) {
        this.jobs = jobs;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
