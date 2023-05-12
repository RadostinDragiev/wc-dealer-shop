package com.example.wcdealershop.repository;

import com.example.wcdealershop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
