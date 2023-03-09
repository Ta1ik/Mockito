package com.example.mockito.services.Impl;

import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static final List<User> USER_LIST = new ArrayList(Arrays.asList(new User("Ivan"), new User ("John"), new User ("Dmitry")));
    private static final List<User> INCORRECT_USER_LIST = new ArrayList(Arrays.asList(new User("Olga"), new User ("Jimmy"), new User ("Stepan")));
    private static final User USER_TEST = USER_LIST.get(0);
    private static final User INCORRECT_USER = INCORRECT_USER_LIST.get(2);
    private static UserDaoImpl mock = org.mockito.Mockito.mock(UserDaoImpl.class);

    @Mock
    UserDaoImpl userDao;

    @InjectMocks
    UserServiceImpl out;

    @BeforeEach
    public void createNewUser(){
        userDao = new UserDaoImpl();
    }

    @Test
    void shouldCheckUserExistReturnTrue() {
        when(mock.findAllUsers()).thenReturn(USER_LIST);
        Assertions.assertTrue(out.checkUserExist(USER_TEST));

    }

    @Test
    void shouldCheckUserExistReturnFalse() {
        when(mock.findAllUsers()).thenReturn(USER_LIST);
        Assertions.assertFalse(out.checkUserExist(INCORRECT_USER));
    }
}