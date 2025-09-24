package com.example.demo.service;

import com.example.demo.entity.AppearanceLanguage;
import com.example.demo.repository.AppearanceLanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class AppearanceLanguageService {
    private final AppearanceLanguageRepository repository;

    public AppearanceLanguageService(AppearanceLanguageRepository repository) {
        this.repository = repository;
    }

    public AppearanceLanguage getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public AppearanceLanguage update(AppearanceLanguage settings) {
        return repository.save(settings);
    }
}
