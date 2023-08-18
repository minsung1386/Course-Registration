package com.swcoach.courseregistration.controller;

import com.swcoach.courseregistration.config.auth.dto.SessionUser;
import com.swcoach.courseregistration.domain.user.UserDto;
import com.swcoach.courseregistration.domain.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // test
    @GetMapping("/api/test")
    public String front() {
        return "From back";
    }

    // 유저 어떻게 가져오는지 테스트 함수
    @GetMapping("/user")
    @ResponseBody
    public SessionUser testMethod(@AuthenticationPrincipal SessionUser sessionUser) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        System.out.println(securityContext);
        return sessionUser;
    }

    @PostMapping("/api/signup")
    public ResponseEntity<String> signup(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("회원가입 정보가 올바르지 않습니다.");
        }

        if (!userDto.password().equals(userDto.password2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            return ResponseEntity.badRequest().body("비밀번호가 일치하지 않습니다.");
        }

        try {
            userService.create(userDto.username(), userDto.password()
                    , userDto.name(), userDto.contact());
            model.addAttribute("success", true);
            return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.rejectValue("username", "signupFailure", "이미 등록된 사용자입니다.");
            return ResponseEntity.badRequest().body("이미 등록된 사용자입니다.");
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailure", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 중 오류가 발생했습니다.");
        }
    }

}
