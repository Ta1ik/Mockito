package com.example.mockito.services.Impl;

import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    private static String USER_NAME = "Ivan";
    private static String INCORRECT_USER_NAME = "Petr";

    private static final List<User> USER_LIST = new ArrayList(Arrays.asList(new User("Ivan"), new User ("John"), new User ("Dmitry")));

    private static final List<User> INCORRECT_USER_LIST = new ArrayList(Arrays.asList(new User("Stepan"), new User ("Jonny"), new User ("Ron")));

    UserDaoImpl userDao;

    @BeforeEach
    private void createNewUser(){
        userDao = new UserDaoImpl();
    }

    @Test
    void shouldReturnGetUserByName() {
        Assertions.assertEquals(USER_NAME, userDao.getUserByName(USER_NAME));
    }

    @Test
    void shouldReturnNullGetUserByName(){
        Assertions.assertNull(null, userDao.getUserByName(INCORRECT_USER_NAME));
    }

    @Test
    void shouldReturnCollectionsUsers(){
        Assertions.assertEquals(userDao.users, userDao.findAllUsers());
    }

    @Test
    void shouldEqualsListUsersFind(){
        Assertions.assertEquals(USER_LIST, userDao.findAllUsers());
    }

    @Test
    void shouldNotEqualsListUsersFind(){
        Assertions.assertNotEquals(INCORRECT_USER_LIST, userDao.findAllUsers());
    }

}