package com.example.demo.service.courseService;


import com.example.demo.dto.courseDTO.CourseCreateDto;
import com.example.demo.dto.courseDTO.CourseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    CourseDto createCourse(CourseCreateDto dto);
    CourseDto getCourse(Long id);
    Page<CourseDto> listCourses(Pageable pageable);
    CourseDto updateCourse(Long id, CourseCreateDto dto);
    void deleteCourse(Long id);
}
