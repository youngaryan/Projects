package com.bank1System.bms1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping(path = "api/v2/bms")
public class UserController {

    private final UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping(path = "/show_all")
    public String showAll(Model model){
        List<User> users = userService.listOfAllUser();
        model.addAttribute("users", users);
        return "showAll";
    }


    @GetMapping(path = "/findById")
    public Optional<User> findId(@RequestParam Long id){
        return userService.findUserById(id);
    }
    @GetMapping(path = "/findByIdPage")
    public String findIdPage(){
        return "foundId";
    }

    @GetMapping(path = "/create_user")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping(path = "/create_user")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user.getName(), user.getEmail());
        return "redirect:/done";
    }

    @GetMapping(path = "done")
    public String done(){
        return "done";
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
