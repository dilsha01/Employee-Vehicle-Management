package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.StatusDTO;
import com.company.motorcyclemanagement.entity.Status;
import com.company.motorcyclemanagement.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<StatusDTO> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public StatusDTO getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }

    @PostMapping
    public StatusDTO saveStatus(@RequestBody Status status) {
        return statusService.getStatusById(statusService.saveStatus(status).getStatusId());
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}
