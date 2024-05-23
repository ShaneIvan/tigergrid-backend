package com.example.tigergrid.service;

import com.example.tigergrid.model.User;
import com.example.tigergrid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User with ID " + id + " successfully deleted!";
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
