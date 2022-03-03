package com.example.springsecurity.service;


import com.example.springsecurity.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService {

    @Transactional
    void save(User user);

    @Transactional
    List<User> findAll();

    @Transactional
    void deleteById(long id);

    @Transactional
    User findById(long id);

    UserDetails loadUserByUsername(String userName);
}
