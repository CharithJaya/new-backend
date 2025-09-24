package com.example.demo.controller;


import com.example.demo.entity.DashboardStats;
import com.example.demo.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/stats")
    public List<DashboardStats> getStats() {
        return dashboardService.getStats();
    }

    @PostMapping("/stats")
    public DashboardStats saveStats(@RequestBody DashboardStats stats) {
        return dashboardService.saveStats(stats);
    }
}
