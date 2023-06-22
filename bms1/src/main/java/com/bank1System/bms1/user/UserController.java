package com.bank1System.bms1.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "forms/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("name") String name, @RequestParam("email") String email ){
        User user = userService.findUserByName(name);
        if (user!=null && user.getEmail().equals(email)){
            return "/home";
        }else {
           return "forms/login";
        }
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping(path = "/show_all")
    public String showAll(Model model){
        List<User> users = userService.listOfAllUser();
        model.addAttribute("users", users);
        return "table/showAll";
    }


    @GetMapping(path = "/findById")
    public String ShowFindIdForm() {
        return "forms/filterFormId";
    }

    @PostMapping(path = "/findById")
    public String findUserId(@RequestParam("id") Long id, Model model) {
        Optional<User> userOptional = userService.findUserById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            model.addAttribute("user",user);
        }
        return "table/userFoundID";
    }

    @GetMapping("/userDetails/{userId}")
    public String findUserFullDetails(@PathVariable("userId") Long userId, Model model) {
        Optional<User> userOptional = userService.findUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
        }
        return "table/userDetails";
    }

    @GetMapping(path = "/findByName")
    public String ShowFindNameForm() {
        return "forms/filterByName";
    }

    @PostMapping(path = "/findByName")
    public String findUserName(@RequestParam("name") String name, Model model) {
        User user = userService.findUserByName(name);
        model.addAttribute("user", user);
        return "table/userFoundName";
    }

    @GetMapping(path = "/findByEmail")
    public String ShowFindEmailForm() {
        return "forms/filterByEmail";
    }

    @PostMapping(path = "/findByEmail")
    public String findUserEmail(@RequestParam("email") String email, Model model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        System.out.println(user);
        return "table/userFoundName";
    }
    @GetMapping(path = "/deleteById")
    public String ShowFindIdFormDelete() {
        return "forms/deleteFormId";
    }

    @PostMapping(path = "/deleteById")
    public String DeleteUserId(@RequestParam("id") Long id, Model model) {
        userService.deleteById(id);
        return "/home";
    }

    @GetMapping(path = "/create_user")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "forms/register";
    }
    @PostMapping(path = "/create_user")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user.getName(), user.getEmail());
        return "generic/done";
    }

    @GetMapping(path = "/generate")
    public String generate(){
        userService.userGenerator();
        return "generic/done";
    }

    @GetMapping(path = "done")
    public String done(){
        return "generic/done";
    }
    @RequestMapping(path = "deleteAll", method = {RequestMethod.GET, RequestMethod.POST})
    public String removeAll() {
        userService.removeAll();
        return "generic/done";
    }

}
