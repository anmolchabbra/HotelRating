package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {
    //Comes all user operations

    //Create User
    User saveUser(User user);

    //Get All users
    List<User> getAllUsers();

    //Get Particular User
    User getUser(String userID);


    //delete User
    User deleteUser(String userID);

    //Update User
    User updateUser(User user);
}
