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


import java.util.HashMap;
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
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Missing 'email' field"));
        }

        if (password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Missing 'password' field"));
        }

        Optional<OtherEmployeeDTO> authenticatedEmployee = otherEmployeeService.authenticate(email, password);

        if (authenticatedEmployee.isPresent()) {
            // Authentication successful
            OtherEmployeeDTO employeeDTO = authenticatedEmployee.get();

            // Prepare response body with RoleId
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Login Successful");
            responseBody.put("roleId", employeeDTO.getRoleId()); // Add RoleId to the response body

            // Log the RoleId (for debugging purposes)
            logger.info("RoleId added to response body: {}", employeeDTO.getRoleId());

            // Return success response with RoleId in body
            return ResponseEntity.ok(responseBody);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid Credentials"));
        }
    }




    @GetMapping("/test")
    public String test() {


        return "Test";
    }
}
