package com.example.demo.controller;

import com.example.demo.entity.NotificationPreferences;
import com.example.demo.service.NotificationPreferencesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationPreferencesService service;

    public NotificationController(NotificationPreferencesService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public NotificationPreferences get(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @PutMapping
    public NotificationPreferences update(@RequestBody NotificationPreferences preferences) {
        return service.update(preferences);
    }
}
