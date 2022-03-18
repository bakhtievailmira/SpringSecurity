package com.example.springsecurity.service;


import com.example.springsecurity.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(User user);

    List<User> findAll();

    void deleteById(long id);

    User findById(long id);

    UserDetails loadUserByUsername(String userName);
}
