package com.example.demo.controller;


import com.example.demo.dto.courseDTO.CourseCreateDto;
import com.example.demo.dto.courseDTO.CourseDto;
import com.example.demo.exception.courseException.ApiError;
import com.example.demo.service.courseService.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    private final CourseService svc;

    @Autowired
    public CourseController(CourseService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseCreateDto dto) {
        CourseDto saved = svc.createCourse(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(svc.getCourse(id));
    }

    @GetMapping
    public ResponseEntity<Page<CourseDto>> listCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<CourseDto> p = svc.listCourses(PageRequest.of(page, size));
        return ResponseEntity.ok(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseCreateDto dto) {
        return ResponseEntity.ok(svc.updateCourse(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        svc.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    // Simple validation error handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError err : ex.getBindingResult().getFieldErrors()) {
            errors.put(err.getField(), err.getDefaultMessage());
        }
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation failed", errors);
        return error;
    }
}
