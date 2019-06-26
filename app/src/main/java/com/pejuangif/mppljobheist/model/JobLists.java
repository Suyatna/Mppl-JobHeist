package com.pejuangif.mppljobheist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class JobLists implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("imageurl")
    private String imageurl;
    @SerializedName("author")
    private String author;
    @SerializedName("category")
    private String category;
    @SerializedName("salary")
    private String salary;
    @SerializedName("location")
    private String location;
    @SerializedName("content_desc")
    private String content_desc;
    @SerializedName("date_created")
    private String date_created;
    @SerializedName("uri_form")
    private String uri_form;

    public JobLists() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent_desc() {
        return content_desc;
    }

    public void setContent_desc(String content_desc) {
        this.content_desc = content_desc;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getUri_form() {
        return uri_form;
    }

    public void setUri_form(String uri_form) {
        this.uri_form = uri_form;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.imageurl);
        dest.writeString(this.author);
        dest.writeString(this.category);
        dest.writeString(this.salary);
        dest.writeString(this.location);
        dest.writeString(this.content_desc);
        dest.writeString(this.date_created);
        dest.writeString(this.uri_form);
    }

    protected JobLists(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.imageurl = in.readString();
        this.author = in.readString();
        this.category = in.readString();
        this.salary = in.readString();
        this.location = in.readString();
        this.content_desc = in.readString();
        this.date_created = in.readString();
        this.uri_form = in.readString();
    }

    public static final Parcelable.Creator<JobLists> CREATOR = new Parcelable.Creator<JobLists>() {
        @Override
        public JobLists createFromParcel(Parcel source) {
            return new JobLists(source);
        }

        @Override
        public JobLists[] newArray(int size) {
            return new JobLists[size];
        }
    };
}
