package com.example.tigergrid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tigergrid.model.User;
import com.example.tigergrid.service.LoggedInService;
import com.example.tigergrid.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoggedInService loggedInService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/getLoggedIn")
    public User getLoggedIn() {
        return loggedInService.getLoggedIn();
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<User> login(@PathVariable String email, @PathVariable String password) {
        List<User> allUsers = userService.getAllUsers();

        for (User user : allUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loggedInService.logIn(user.getId());
                return ResponseEntity.ok(user);
            }
        }
        loggedInService.logOut();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping("/logout")
    public String logout() {
        loggedInService.logOut();
        return "Logout successful!";
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
