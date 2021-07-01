package com.fundinghelp.moniruzzamanshadhinapplication.model;

import com.google.gson.annotations.SerializedName;

public class JobsDate {


    @SerializedName("Title")
    private String title;

    @SerializedName("LastDate")
    private String lastDate;

    @SerializedName("CompanyName")
    private String companyName;

    @SerializedName("ApplyInstruction")
    private String applyInstruction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getApplyInstruction() {
        return applyInstruction;
    }

    public void setApplyInstruction(String applyInstruction) {
        this.applyInstruction = applyInstruction;
    }
}
