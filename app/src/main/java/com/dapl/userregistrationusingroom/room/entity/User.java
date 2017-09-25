package com.dapl.userregistrationusingroom.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * TODO: Created by Tanay Mondal on 25-09-2017
 */
@Entity
public class User implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String userName;
    public String userEmail;
    public String userPass;

    public User() {
    }

    public User(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        userEmail = in.readString();
        userPass = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeString(userName);
        parcel.writeString(userEmail);
        parcel.writeString(userPass);
    }
}
