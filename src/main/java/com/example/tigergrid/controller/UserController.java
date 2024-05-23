package com.example.tigergrid.controller;

import com.example.tigergrid.model.User;
import com.example.tigergrid.service.LoggedInService;
import com.example.tigergrid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String create(@PathVariable int id) {
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
    public User login(@PathVariable String email, @PathVariable String password) {
        List<User> allUsers = userService.getAllUsers();

        for(User user : allUsers) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loggedInService.logIn(user.getId());
                return user;
            }
        }
        loggedInService.logOut();
        return null;
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
