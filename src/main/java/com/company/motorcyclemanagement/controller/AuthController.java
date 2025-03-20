package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.OtherEmployeeDTO;
import com.company.motorcyclemanagement.service.OtherEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private OtherEmployeeService otherEmployeeService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body("Missing 'email' field");
        }

        if (password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body("Missing 'password' field");
        }

        Optional<OtherEmployeeDTO> authenticatedEmployee = otherEmployeeService.authenticate(email, password);

        if (authenticatedEmployee.isPresent()) {
            // Authentication successful
            OtherEmployeeDTO employeeDTO = authenticatedEmployee.get();

            // Prepare headers with RoleId
            HttpHeaders headers = new HttpHeaders();
            headers.add("RoleId", String.valueOf(employeeDTO.getRoleId())); // Add RoleId to header

            // Log the headers (for debugging purposes)
            logger.info("RoleId added to response header: {}", headers.getFirst("RoleId"));

            // Return success response with headers
            return ResponseEntity.ok()
                    .headers(headers) // Set headers
                    .body("Login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }



    @GetMapping("/test")
    public String test() {


        return "Test";
    }
}
