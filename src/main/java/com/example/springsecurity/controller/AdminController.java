package com.example.springsecurity.controller;


import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.User;
import com.example.springsecurity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")

public class AdminController {


    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("listroles", Role.values());
        return "new";
    }

    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user, Model model) {
        User userFromDB = (User) userService.loadUserByUsername(user.getUsername());
        if (userFromDB != null) {
            model.addAttribute("message", "User with such email already exists");
            return "new";
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping()
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("listroles", Role.values());
        return "edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }


    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "show";
    }
}