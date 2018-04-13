package com.example.cfgs.esteroidesapk;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
    private String user;
    private int points;

    public Category() {
        super();
    }

    public Category(String tittle, int description) {
        super();
        this.user = tittle;
        this.points = description;
    }

    public Category(Parcel in){
        this.user= in.readString();
        this.points  = in.readInt();
    }


    public String getUser() {
        return user;
    }

    public void setUser(String title) {
        this.user = title;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getUser());
        dest.writeInt(getPoints());
    }
    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

}
