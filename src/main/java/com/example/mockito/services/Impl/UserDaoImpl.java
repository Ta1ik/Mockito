package com.example.mockito.services.Impl;

import com.example.mockito.exception.UserNotFoundException;
import com.example.mockito.model.User;
import com.example.mockito.services.UserDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public List<User> users;


    public UserDaoImpl() {
        this.users = new ArrayList(Arrays.asList(new User("Ivan"), new User ("John"), new User ("Dmitry")));
    }

    @Override
    public String getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user.getName();
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        if (users.isEmpty()) {
            throw new UserNotFoundException("Пользователи не найдены");
        } else {
            return users;
        }
    }
}
