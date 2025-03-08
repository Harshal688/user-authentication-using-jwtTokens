package com.skyblue.jwtproject.controller;

import com.skyblue.jwtproject.model.Users;
import com.skyblue.jwtproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("Login")
    public String doLogin(@RequestBody Users user) {
        return userService.verify(user);
    }


    @PostMapping("register")
    public String setUsers(@RequestBody Users user) {

        return userService.saveUsers(user);
    }

    @GetMapping("users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
}
