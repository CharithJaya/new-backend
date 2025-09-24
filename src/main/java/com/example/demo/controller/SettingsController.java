package com.example.demo.controller;

import com.example.demo.entity.AppearanceLanguage;
import com.example.demo.entity.SystemSettings;
import com.example.demo.service.AppearanceLanguageService;
import com.example.demo.service.SystemSettingsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    private final AppearanceLanguageService appearanceService;
    private final SystemSettingsService systemService;

    public SettingsController(AppearanceLanguageService appearanceService, SystemSettingsService systemService) {
        this.appearanceService = appearanceService;
        this.systemService = systemService;
    }

    // Appearance
    @GetMapping("/appearance/{userId}")
    public AppearanceLanguage getAppearance(@PathVariable Long userId) {
        return appearanceService.getByUserId(userId);
    }

    @PutMapping("/appearance")
    public AppearanceLanguage updateAppearance(@RequestBody AppearanceLanguage settings) {
        return appearanceService.update(settings);
    }

    // System
    @GetMapping("/system")
    public List<SystemSettings> getSystemSettings() {
        return systemService.getAll();
    }

    @PutMapping("/system")
    public SystemSettings updateSystem(@RequestBody SystemSettings settings) {
        return systemService.update(settings);
    }
}

