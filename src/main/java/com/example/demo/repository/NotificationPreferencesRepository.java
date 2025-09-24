package com.example.demo.repository;


import com.example.demo.entity.NotificationPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationPreferencesRepository extends JpaRepository<NotificationPreferences, Long> {
    NotificationPreferences findByUserId(Long userId);
}
