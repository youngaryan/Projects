package com.bank1System.bms1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/bms")
public class UserController {

    private final UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> get() {
        return userService.listOfAllUser();
    }

    @GetMapping(path = "/findById")
    public Optional<User> findId(@RequestParam Long id){
        return userService.findUserById(id);
    }
    @GetMapping(path = "/create_user")
    public void createUser(@RequestParam String name, @RequestParam String email){
        userService.createUser(name, email);
    }
    @RequestMapping(path = "deleteAll", method = {RequestMethod.GET, RequestMethod.POST})
    public void removeAll() {
        userService.removeAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String errorMessage = "An error occurred. Please try again later.";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(errorMessage);
    }

}
