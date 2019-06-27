package com.pejuangif.mppljobheist.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PencariPekerjaanData {

    @SerializedName("status")
    private String status;
    @SerializedName("pencari_kerja")
    private ArrayList<PencariPekerjaan> pencariPekerjaanArray;
    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<PencariPekerjaan> getPencariPekerjaanArray() {
        return pencariPekerjaanArray;
    }

    public void setPencariPekerjaanArray(ArrayList<PencariPekerjaan> pencariPekerjaanArray) {
        this.pencariPekerjaanArray = pencariPekerjaanArray;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
