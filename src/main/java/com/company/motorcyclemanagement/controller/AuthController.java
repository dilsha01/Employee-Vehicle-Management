package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.service.OtherEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private OtherEmployeeService otherEmployeeService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String name = credentials.get("email");
        String password = credentials.get("password");

        if (name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().body("Missing 'email' field");
        }

        if (password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body("Missing 'password' field");
        }

        if (otherEmployeeService.authenticate(name, password)) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.ok("Invalid Credentials");
        }
    }


    @GetMapping("/test")
    public String test() {


        return "Test";
    }
}
