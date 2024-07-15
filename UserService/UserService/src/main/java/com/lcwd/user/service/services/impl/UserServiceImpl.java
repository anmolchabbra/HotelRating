package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userID) {
        return userRepository.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("User with given id is not found on server !!" + userID));
    }

    @Override
    public User deleteUser(String userID) {
        Optional<User> user = userRepository.findById(userID);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return user.get();
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getUserID());
        if (userOptional.isPresent()) {
            User toUpdate = userOptional.get();
            toUpdate.setAbout(user.getAbout());
            toUpdate.setName(user.getName());
            toUpdate.setEmail(user.getEmail());
        }
        return userOptional.get();
    }
}
