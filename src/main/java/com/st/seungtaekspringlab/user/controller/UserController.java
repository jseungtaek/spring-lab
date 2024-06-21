package com.st.seungtaekspringlab.user.controller;

import com.st.seungtaekspringlab.user.dto.SignInDto;
import com.st.seungtaekspringlab.user.dto.SignUpDto;
import com.st.seungtaekspringlab.user.exception.UserErrorResponseEntity;
import com.st.seungtaekspringlab.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<Boolean> signUp(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(userService.signUp(signUpDto));
    }

    @PostMapping("/signIn")
    public ResponseEntity<Boolean> singIn (@RequestBody SignInDto signInDto) {
        return ResponseEntity.ok(userService.signIn(signInDto));
    }
}
