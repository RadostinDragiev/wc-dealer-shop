package com.example.wcdealershop.service.impl;

import com.example.wcdealershop.models.Role;
import com.example.wcdealershop.models.User;
import com.example.wcdealershop.models.UserRole;
import com.example.wcdealershop.models.dtos.UserRegisterDto;
import com.example.wcdealershop.repository.UserRepository;
import com.example.wcdealershop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper.map(userRegisterDto, User.class);
        LocalDateTime now = LocalDateTime.now();
        user.setCreated(now);
        user.setModified(now);
        user.setActive(true);
        UserRole userRole = new UserRole();
        long usersCount = this.userRepository.count();
        if (usersCount > 1) {
            if (usersCount % 2 == 0) {
                userRole = new UserRole(Role.SELLER);
            } else {
                userRole = new UserRole(Role.BUYER);
            }
        } else {
            userRole = new UserRole(Role.ADMINISTRATOR);
        }
        user.setRole(userRole);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }
}
