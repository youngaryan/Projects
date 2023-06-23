package com.moreAdvanceMailSender.User1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPin(String pin);
}
