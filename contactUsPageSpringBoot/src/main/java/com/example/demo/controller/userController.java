package com.example.demo.controller;

import com.example.demo.serivice.UserService;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String showUser(@PathVariable Long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("User", user);
        return "newUser";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "newUser";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @DeleteMapping
    public String deleteAll(){
        userService.deleteAllUser();
        return "redirect:/users";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users/" + user.getId();
    }
}
