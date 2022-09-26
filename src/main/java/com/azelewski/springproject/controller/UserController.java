package com.azelewski.springproject.controller;

import com.azelewski.springproject.model.User;
import com.azelewski.springproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("view-users")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/list-users";
    }
    @GetMapping("/user-details")
    public String getUserDetails(@RequestParam("userId") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-details";
    }
    @GetMapping("/update-user")
    public String update(@RequestParam("userId") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "/user-form";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user/view-users";
    }
    @GetMapping("/search")
    public String searchUsers(@RequestParam("searchValue") String searchValue, Model model){
        List<User> users = userService.searchUsers(searchValue);
        model.addAttribute("users", users);
        return "/list-users";
    }
}
