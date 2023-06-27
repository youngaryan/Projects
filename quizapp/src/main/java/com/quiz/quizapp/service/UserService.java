package com.quiz.quizapp.service;

import com.quiz.quizapp.dto.UserDto;
import com.quiz.quizapp.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
