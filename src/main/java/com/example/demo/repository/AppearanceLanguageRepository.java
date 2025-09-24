package com.example.demo.repository;


import com.example.demo.entity.AppearanceLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppearanceLanguageRepository extends JpaRepository<AppearanceLanguage, Long> {
    AppearanceLanguage findByUserId(Long userId);
}
