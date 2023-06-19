package com.example.demo.repository;

import com.example.demo.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryInterface extends CrudRepository<User, Long> {
}
