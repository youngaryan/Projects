package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")

public class MainController {
    @Autowired

    private UserRepository userRepository;
    private User user;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email){

        User n = new User();
        n.setEmail(email);
        n.setName(name);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/returnNumber1")
    public User getUser(Integer id, List<User> users) {
        User user = users.stream().filter(t -> id.equals(t.getId())).findFirst().orElse(null);
        return user;
    }

}
