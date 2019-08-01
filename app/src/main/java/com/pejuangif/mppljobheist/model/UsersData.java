package com.pejuangif.mppljobheist.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UsersData {

    @SerializedName("status")
    private String status;
    @SerializedName("jobs")
    private ArrayList<Users> usersArrayList;
    @SerializedName("message")
    private String message;

    public ArrayList<Users> getUsersArrayList() {
        return usersArrayList;
    }
}
