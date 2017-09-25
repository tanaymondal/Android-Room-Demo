package com.dapl.userregistrationusingroom;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.dapl.userregistrationusingroom.room.db.AppDatabase;

/**
 * TODO: Created by Tanay Mondal on 25-09-2017
 */

public class AppController extends Application {
    private static AppController instance = null;

    public static AppController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public AppDatabase getDb() {
        return Room.databaseBuilder(this, AppDatabase.class, "UserManager.db").allowMainThreadQueries().build();
    }
}
