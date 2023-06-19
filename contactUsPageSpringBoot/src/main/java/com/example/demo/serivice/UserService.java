package com.example.demo.serivice;

import com.example.demo.repository.UserRepositoryInterface;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepositoryInterface userRepositoryInterface;

    @Autowired
    public UserService(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }

    public User findUserById(Long id){
        return userRepositoryInterface.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return userRepositoryInterface.save(user);
    }

    public List<User> returnAll(){
        return (List<User>) userRepositoryInterface.findAll();
    }

    public void deleteUser(Long id){
        userRepositoryInterface.deleteById(id);
    }
    public void deleteAllUser(){
        userRepositoryInterface.deleteAll();
    }
}
