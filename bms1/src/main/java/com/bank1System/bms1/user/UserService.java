package com.bank1System.bms1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listOfAllUser() {
        return userRepository.findAll();
    }
    public void removeAll(){
        userRepository.deleteAll();
    }


    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public User findUserByName(String name) {
        for (User user:listOfAllUser()){
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String name){
        for (User user:listOfAllUser()){
            if (user.getEmail().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void createUser(String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);
    }
}
