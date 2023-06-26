package com.bank1System.bms1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
	

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//
//    private int currentPage = 0; // Initial page number
//    private int pageSize = 10; // Set the desired page size

//    public List<User> listOfAllUser() {
//        Pageable pageable = PageRequest.of(currentPage, pageSize);
//        Page<User> userPage = userRepository.findAll(pageable);
//        List<User> userList = userPage.getContent();
//
//        // Increment the current page number
//        currentPage++;
//
//        return userList;
//    }

    public List<User> listOfAllUser(){
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
        Random random = new Random();
        final Long[] BALANCE  = {100L,200L,1234L,3121L,132421L,13223L,1917L,1870L,1871L,1959L};
        final String[] REVIEW  = {"trusted", "so-so","not trusted"};
        User user = new User(name, email, BALANCE[random.nextInt(BALANCE.length-1)], REVIEW[random.nextInt(REVIEW.length-1)]);
        userRepository.save(user);
    }


    public void userGenerator(){
        final String[] FIRST_NAMES = {
                "John Smith", "Jane Johnson", "David Williams", "Emily Jones", "Michael Brown", "Olivia Davis"
        };
        final String[] EMAILS = {
                "JohnSmith@gmail.com", "JaneJohnson@gmail.com", "DavidWilliams@gmail.com", "EmilyJones@gmail.com", "MichaelBrown@gmail.com", "Olivia Davis@gmail.com"
        };
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            createUser(FIRST_NAMES[random.nextInt(FIRST_NAMES.length-1)], EMAILS[random.nextInt(FIRST_NAMES.length-1)]);
        }
    }
}
