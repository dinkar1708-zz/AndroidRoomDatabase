package com.android.room.database.service;

import android.arch.persistence.room.Insert;

import com.android.room.database.db.entity.User;

import java.util.List;

/**
 * Created by dinakar.maurya on 25-01-2018.
 */

/**
 * writing my own service interface
 */
public interface UserService {

    List<User> getAll();

    void insertAll(User... users);
}
