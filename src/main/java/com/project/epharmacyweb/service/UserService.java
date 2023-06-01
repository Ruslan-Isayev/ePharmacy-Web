package com.project.epharmacyweb.service;

import com.project.epharmacyweb.entity.User;
import com.project.epharmacyweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public Object login() {
        return null;
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public void save(User user) {
        
    }
}