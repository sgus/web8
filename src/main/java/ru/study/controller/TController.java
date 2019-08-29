package ru.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.study.model.User;
import ru.study.service.UserService;

import java.util.List;

@Controller
public class TController {

    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String viewer() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/a")
    public String viewer2(Model model) {
        System.out.println("admin");
         List<User> allUsers = userService.getAllUsers();
         allUsers.stream().forEach(user -> System.out.println(user.toString()));
        model.addAttribute("users", allUsers);
        return "admin";
    }
}
