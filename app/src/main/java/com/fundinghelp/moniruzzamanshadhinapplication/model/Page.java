package com.fundinghelp.moniruzzamanshadhinapplication.model;

import com.google.gson.annotations.SerializedName;

public class Page {
    @SerializedName("total_records_found")
    private int totalRecordsFound;

    @SerializedName("totalpages")
    private int totalpages;

    public int getTotalRecordsFound() {
        return totalRecordsFound;
    }

    public void setTotalRecordsFound(int totalRecordsFound) {
        this.totalRecordsFound = totalRecordsFound;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }
}
