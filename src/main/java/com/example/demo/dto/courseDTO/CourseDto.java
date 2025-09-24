package com.example.demo.dto.courseDTO;


import java.math.BigDecimal;
import java.time.Instant;

public class CourseDto {
    private Long id;
    private String name;
    private String subject;
    private String instructorName;
    private BigDecimal fee;
    private String schedule;
    private String duration;
    private String description;
    private Instant createdAt;

    // getters & setters
    // ... omitted for brevity (same pattern as CourseCreateDto plus id & createdAt)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    public java.math.BigDecimal getFee() { return fee; }
    public void setFee(java.math.BigDecimal fee) { this.fee = fee; }
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
