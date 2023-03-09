package com.example.mockito.services;

import com.example.mockito.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao {

    String getUserByName(String name);

    List<User> findAllUsers();
}
