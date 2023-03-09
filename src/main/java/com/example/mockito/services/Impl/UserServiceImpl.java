package com.example.mockito.services.Impl;

import com.example.mockito.model.User;
import com.example.mockito.services.UserDao;
import com.example.mockito.services.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public boolean checkUserExist(User user) {
        userDao = new UserDaoImpl();
        if (userDao.findAllUsers().contains(user)) {
            return true;
        } else {
            return false;
        }
    }
}
