package com.example.wcdealershop.service;

import com.example.wcdealershop.models.User;
import com.example.wcdealershop.models.dtos.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    User getUserByUsername(String username);
}
