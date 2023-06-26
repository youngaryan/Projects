package com.quiz.quizapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(String name, String email){
        if (userRepository.findByEmail(email) == null ) {
            userRepository.save(new User(name, email));
        }
    }
}
