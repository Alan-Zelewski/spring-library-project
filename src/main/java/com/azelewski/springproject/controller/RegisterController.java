package com.azelewski.springproject.controller;

import com.azelewski.springproject.exception.UserAlreadyExistsException;
import com.azelewski.springproject.infrastructure.UserDTO;
import com.azelewski.springproject.model.User;
import com.azelewski.springproject.service.UserService;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/main")
@AllArgsConstructor
public class RegisterController {

    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationFrom(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        return "/register";
    }
    @PostMapping("/registrationProcessing")
    public String registerUserAccount(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                            BindingResult result,
                                            Model model){
        if(result.hasErrors()){
            return "/register";
        }
        if(userService.checkIfUserAlreadyExist(userDTO)){
            model.addAttribute("userDTO", new UserDTO());
            model.addAttribute("registrationError", "Username/email already exists.");
            return "/register";
        }
        userService.save(userDTO);
        return "/register-success";
    }
}
