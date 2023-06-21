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
    public String ShowFindIdForm() {
        return "filterFormId";
    }

    @PostMapping(path = "/findById")
    public String createUser(@RequestParam("id") Long id, Model model) {
        Optional<User> userOptional = userService.findUserById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            model.addAttribute("user",user);
        }
        return "userFoundID";
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
    public String removeAll() {
        userService.removeAll();
        return "redirect:/done";
    }



}
