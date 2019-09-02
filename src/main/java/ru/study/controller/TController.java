package ru.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.study.model.Role;
import ru.study.model.User;
import ru.study.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class TController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal Principal principal) {
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "index";
    }

    @RequestMapping("/admin")
    public String viewer2(Model model) {
        List<User> allUsers = userService.getAllUsers();
        allUsers.stream().forEach(user -> System.out.println(user.toString()));
        model.addAttribute("users", allUsers);
        return "admin";
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(name = "id", required = false) Long id) {
        System.out.println(id);
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public String editButton(@RequestParam(name = "id") Long id, Model model) {
        System.out.println(id);
        User userById = userService.getUserById(id);
        System.out.println(userById.getLogin());
        model.addAttribute("user", userById);
        return "edit";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@ModelAttribute("user") User user)  {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register", "user", new User());
    }



    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("user")User user, Model model) {
        userService.updateUser(user);
        return "redirect:/admin";
    }


}
