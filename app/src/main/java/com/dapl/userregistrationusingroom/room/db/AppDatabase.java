package com.dapl.userregistrationusingroom.room.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dapl.userregistrationusingroom.room.dao.UserDao;
import com.dapl.userregistrationusingroom.room.entity.User;


/**
 * TODO: Created by Tanay Mondal on 26-07-2017
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
