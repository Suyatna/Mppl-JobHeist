package com.pejuangif.mppljobheist.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private int id;
    private String levelUsers;
    private String name;
    private String email;
    private String generate_token;
    private String avatar;
    private String alamat;
    private String pendidikan_terakhir;
    private String cv;
    private String nama_perusahaan;

    public Users() {

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

    public String getGenerate_token() {
        return generate_token;
    }

    public void setGenerate_token(String generate_token) {
        this.generate_token = generate_token;
    }

    public String getLevelUsers() {
        return levelUsers;
    }

    public void setLevelUsers(String levelUsers) {
        this.levelUsers = levelUsers;
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

    public String getNama_perusahaan() {
        return nama_perusahaan;
    }

    public void setNama_perusahaan(String nama_perusahaan) {
        this.nama_perusahaan = nama_perusahaan;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.levelUsers);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.generate_token);
        dest.writeString(this.avatar);
        dest.writeString(this.alamat);
        dest.writeString(this.pendidikan_terakhir);
        dest.writeString(this.cv);
        dest.writeString(this.nama_perusahaan);
    }

    protected Users(Parcel in) {
        this.id = in.readInt();
        this.levelUsers = in.readString();
        this.name = in.readString();
        this.email = in.readString();
        this.generate_token = in.readString();
        this.avatar = in.readString();
        this.alamat = in.readString();
        this.pendidikan_terakhir = in.readString();
        this.cv = in.readString();
        this.nama_perusahaan = in.readString();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel source) {
            return new Users(source);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };
}
