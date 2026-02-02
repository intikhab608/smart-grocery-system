package com.grocery.user_service.service;

import com.grocery.user_service.entity.User;
import com.grocery.user_service.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo= userRepo;
    }

    public User create(User user){
        return userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public User getUserById(long id){
        return userRepo.findById(id).orElse(null);
    }

    public User updateUser(long id, User updatedUser){

        User existingUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepo.save(existingUser);

    }
}
