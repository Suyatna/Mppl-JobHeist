package com.pejuangif.mppljobheist.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PencariKerja extends Users implements Parcelable {
    public static String EXTRA_PENCARI_KERJA = "extra-pencari-kerja";

    private int id;
    private String name;
    private String email;
    private String generate_token;

    public PencariKerja() {

    }

    public PencariKerja(int id, String name, String email, String generate_token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.generate_token = generate_token;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.generate_token);
    }

    private PencariKerja(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        this.generate_token = in.readString();
    }

    public static final Parcelable.Creator<Users> CREATOR = new Parcelable.Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel source) {
            return new PencariKerja(source);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };
}
