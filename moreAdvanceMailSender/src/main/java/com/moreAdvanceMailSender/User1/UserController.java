package com.moreAdvanceMailSender.User1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //login-page
    @GetMapping("/")
    public String userAuthentication(Model model){
        model.addAttribute("email", "");
        return "/index";
    }

    @GetMapping("/sentEmail")
    public String check(Model model, @RequestParam("email") String email){
        userService.sendEmailAdvance(email);
        model.addAttribute("email", email);
        return "/check";
    }

    @PostMapping("/checkCode")
    public String checkAuth(@RequestParam("value") String value, Model model) {
        boolean isAuthenticated = userService.checkAuthentication(value);
        if (isAuthenticated) {
            return "success";
        } else {
            model.addAttribute("errorMessage", "Invalid authentication code");
            return "check";
        }
    }
}
