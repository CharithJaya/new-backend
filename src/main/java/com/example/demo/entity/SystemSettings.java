package com.example.demo.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_settings")
public class SystemSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean automaticBackups;
    private String dataRetentionPeriod; // e.g., "1 Year"
    private int sessionTimeout; // in minutes
}
