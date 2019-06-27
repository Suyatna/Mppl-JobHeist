package com.pejuangif.mppljobheist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PencariPekerjaan implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("generate_token")
    private String generate_token;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("pendidikan_terakhir")
    private String pendidikan_terakhir;
    @SerializedName("cv")
    private String cv;

    public PencariPekerjaan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenerate_token() {
        return generate_token;
    }

    public void setGenerate_token(String generate_token) {
        this.generate_token = generate_token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPendidikan_terakhir() {
        return pendidikan_terakhir;
    }

    public void setPendidikan_terakhir(String pendidikan_terakhir) {
        this.pendidikan_terakhir = pendidikan_terakhir;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.generate_token);
        dest.writeString(this.avatar);
        dest.writeString(this.alamat);
        dest.writeString(this.pendidikan_terakhir);
        dest.writeString(this.cv);
    }

    protected PencariPekerjaan(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.generate_token = in.readString();
        this.avatar = in.readString();
        this.alamat = in.readString();
        this.pendidikan_terakhir = in.readString();
        this.cv = in.readString();
    }

    public static final Parcelable.Creator<PencariPekerjaan> CREATOR = new Parcelable.Creator<PencariPekerjaan>() {
        @Override
        public PencariPekerjaan createFromParcel(Parcel source) {
            return new PencariPekerjaan(source);
        }

        @Override
        public PencariPekerjaan[] newArray(int size) {
            return new PencariPekerjaan[size];
        }
    };
}
