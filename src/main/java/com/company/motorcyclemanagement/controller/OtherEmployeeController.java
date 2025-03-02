package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.OtherEmployeeDTO;
import com.company.motorcyclemanagement.service.OtherEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/other-employee")
public class OtherEmployeeController {
    @Autowired
    private OtherEmployeeService otherEmployeeService;

    @GetMapping
    public List<OtherEmployeeDTO> getAllOtherEmployees() {
        return otherEmployeeService.getAllOtherEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherEmployeeDTO> getOtherEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(otherEmployeeService.getOtherEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<OtherEmployeeDTO> createOtherEmployee(@RequestBody OtherEmployeeDTO otherEmployeeDTO) {
        return ResponseEntity.ok(otherEmployeeService.createOtherEmployee(otherEmployeeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherEmployeeDTO> updateOtherEmployee(@PathVariable Long id, @RequestBody OtherEmployeeDTO otherEmployeeDTO) {
        return ResponseEntity.ok(otherEmployeeService.updateOtherEmployee(id, otherEmployeeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOtherEmployee(@PathVariable Long id) {
        otherEmployeeService.deleteOtherEmployee(id);
        return ResponseEntity.ok("OtherEmployee deleted successfully");
    }
}
