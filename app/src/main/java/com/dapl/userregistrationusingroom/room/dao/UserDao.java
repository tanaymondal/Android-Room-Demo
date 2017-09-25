package com.dapl.userregistrationusingroom.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dapl.userregistrationusingroom.room.entity.User;

/**
 * TODO: Created by Tanay Mondal on 25-09-2017
 */

@Dao
public interface UserDao {

    @Insert
    void insertAll(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user WHERE userEmail = (:email) AND userPass = (:password)")
    User getUserByEmail(String email, String password);

    @Query("SELECT * FROM user WHERE userEmail = (:email)")
    User isEmailAvailable(String email);
}
