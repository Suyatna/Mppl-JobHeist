package com.pejuangif.mppljobheist.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JobListData {

    @SerializedName("status")
    private String status;
    @SerializedName("jobs")
    private ArrayList<JobLists> jobListsArray;
    @SerializedName("message")
    private String message;

    public JobListData() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<JobLists> getJobListsArray() {
        return jobListsArray;
    }

    public void setJobListsArray(ArrayList<JobLists> jobListsArray) {
        this.jobListsArray = jobListsArray;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
