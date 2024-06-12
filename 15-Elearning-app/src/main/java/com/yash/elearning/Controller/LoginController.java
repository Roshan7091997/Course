package com.yash.elearning.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.elearning.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/app")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/jsplogin")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String userType) {
        return loginService.loginUser(username, password, userType);
    }
}
