package com.example.tigergrid.service;

import com.example.tigergrid.model.LoggedIn;
import com.example.tigergrid.model.User;
import com.example.tigergrid.repository.LoggedInRepository;
import com.example.tigergrid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggedInService {
    @Autowired
    private LoggedInRepository loggedInRepository;
    @Autowired
    private UserRepository userRepository;

    public User getLoggedIn() {
        LoggedIn loggedIn = loggedInRepository.findById(1).orElse(null);
        if(loggedIn != null) {
            return userRepository.findById(loggedIn.getUserId()).orElse(null);
        }
        return null;
    }

    public User logIn(int id) {
        LoggedIn loggedIn = new LoggedIn();
        loggedIn.setId(1);
        loggedIn.setUserId(id);
        loggedInRepository.save(loggedIn);
        return userRepository.findById(id).orElse(null);
    }

    public LoggedIn logOut() {
        LoggedIn loggedIn = new LoggedIn();
        loggedIn.setId(1);
        loggedIn.setUserId(-1);
        return loggedInRepository.save(loggedIn);
    }
}
