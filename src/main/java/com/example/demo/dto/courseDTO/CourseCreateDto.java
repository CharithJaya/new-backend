package com.example.demo.dto.courseDTO;


import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CourseCreateDto {

    @NotBlank(message = "Course name is required")
    private String name;

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotBlank(message = "Instructor name is required")
    private String instructorName;

    @NotNull(message = "Fee is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Fee must be positive")
    private BigDecimal fee;

    @NotBlank(message = "Schedule is required")
    private String schedule;

    @NotBlank(message = "Duration is required")
    private String duration;

    @NotBlank(message = "Description is required")
    @Size(max = 4000)
    private String description;

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }

    public BigDecimal getFee() { return fee; }
    public void setFee(BigDecimal fee) { this.fee = fee; }

    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
