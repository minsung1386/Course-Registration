package com.swcoach.courseregistration.controller;

import com.swcoach.courseregistration.domain.user.UserCreateForm;
import com.swcoach.courseregistration.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userCreateForm", new UserCreateForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (!userCreateForm.getPassword().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup";
        }

        try {
            userService.create(userCreateForm.getUsername(), userCreateForm.getPassword()
                    , userCreateForm.getName(), userCreateForm.getContact());
            model.addAttribute("success", true);
            return "signup";
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.rejectValue("username", "signupFailure",
                    "이미 등록된 사용자입니다.");
            return "signup";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailure", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
