package com.lcwd.user.service.controllers;


import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //get all users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    //get one user

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //update user
    @PutMapping("/{userID}")
    public ResponseEntity<User> updateUser(@PathVariable String userID, @RequestBody User user) {
        User user1 = userService.updateUser(userID, user);
        return ResponseEntity.ok(user1);
    }

    //delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable  String userID) {
        User user = userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }
}
