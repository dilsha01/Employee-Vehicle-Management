package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.service.OtherEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private OtherEmployeeService otherEmployeeService;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String name = credentials.get("name");
        String password = credentials.get("password");

        if (otherEmployeeService.authenticate(name, password)) {
            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }
}
