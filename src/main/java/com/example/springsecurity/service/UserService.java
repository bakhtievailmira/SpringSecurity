package com.example.springsecurity.service;



import com.example.springsecurity.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    void save(User user);

    @Transactional
    List<User> findAll();

    @Transactional
    void deleteById(long id);

    @Transactional
    User findById(long id);
}
