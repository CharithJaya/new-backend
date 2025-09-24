package com.example.demo.service;

import com.example.demo.entity.DashboardStats;
import com.example.demo.repository.DashboardStatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private final DashboardStatsRepository repository;

    public DashboardService(DashboardStatsRepository repository) {
        this.repository = repository;
    }

    public List<DashboardStats> getStats() {
        return repository.findAll();
    }

    public DashboardStats saveStats(DashboardStats stats) {
        return repository.save(stats);
    }
}
