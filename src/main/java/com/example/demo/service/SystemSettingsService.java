package com.example.demo.service;



import com.example.demo.entity.SystemSettings;
import com.example.demo.repository.SystemSettingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemSettingsService {
    private final SystemSettingsRepository repository;

    public SystemSettingsService(SystemSettingsRepository repository) {
        this.repository = repository;
    }

    public List<SystemSettings> getAll() {
        return repository.findAll();
    }

    public SystemSettings update(SystemSettings settings) {
        return repository.save(settings);
    }
}
