package com.grocery.user_service.controller;

import com.grocery.user_service.entity.User;
import com.grocery.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User savedUser = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User userById = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userById);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User user){
        User updatedUser = userService.updateUser(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }



}
