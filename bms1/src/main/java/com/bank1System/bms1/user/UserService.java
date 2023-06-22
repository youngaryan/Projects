package com.bank1System.bms1.user;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void userGenerator(){
        final String[] FIRST_NAMES = {
                "John Smith", "Jane Johnson", "David Williams", "Emily Jones", "Michael Brown", "Olivia Davis"
        };
        final String[] EMAILS = {
                "JohnSmith@gmail.com", "JaneJohnson@gmail.com", "DavidWilliams@gmail.com", "EmilyJones@gmail.com", "MichaelBrown@gmail.com", "Olivia Davis@gmail.com"
        };
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            createUser(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)], EMAILS[random.nextInt(FIRST_NAMES.length)]); ;
        }
    }
}
