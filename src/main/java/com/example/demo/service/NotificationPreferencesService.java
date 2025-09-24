package com.example.demo.service;

import com.example.demo.entity.NotificationPreferences;
import com.example.demo.repository.NotificationPreferencesRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationPreferencesService {
    private final NotificationPreferencesRepository repository;

    public NotificationPreferencesService(NotificationPreferencesRepository repository) {
        this.repository = repository;
    }

    public NotificationPreferences getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public NotificationPreferences update(NotificationPreferences preferences) {
        return repository.save(preferences);
    }
}
