package com.example.mockito.services;

import com.example.mockito.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService{

    boolean checkUserExist(User user);
}
