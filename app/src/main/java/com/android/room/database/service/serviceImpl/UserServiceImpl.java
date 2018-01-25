package com.android.room.database.service.serviceImpl;

import android.content.Context;

import com.android.room.database.db.AppDatabase;
import com.android.room.database.db.dao.UserDao;
import com.android.room.database.db.entity.User;
import com.android.room.database.service.UserService;

import java.util.List;

/**
 * Created by dinakar.maurya on 25-01-2018.
 */

/**
 * writing my own impls
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(Context context) {
        userDao = AppDatabase.getInstance(context).userDao();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void insertAll(User... users) {
        userDao.insertAll(users);
    }
}
