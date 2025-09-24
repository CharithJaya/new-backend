package com.example.demo.service.courseService;


import com.example.demo.dto.courseDTO.CourseCreateDto;
import com.example.demo.dto.courseDTO.CourseDto;
import com.example.demo.exception.courseException.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repo;

    @Autowired
    public CourseServiceImpl(CourseRepository repo) {
        this.repo = repo;
    }

    @Override
    public CourseDto createCourse(CourseCreateDto dto) {
        Course course = toEntity(dto);
        Course saved = repo.save(course);
        return toDto(saved);
    }

    @Override
    public CourseDto getCourse(Long id) {
        Course c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found: " + id));
        return toDto(c);
    }

    @Override
    public Page<CourseDto> listCourses(Pageable pageable) {
        Page<Course> page = repo.findAll(pageable);
        return page.map((Function<Course, CourseDto>) this::toDto);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseCreateDto dto) {
        Course course = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found: " + id));
        course.setName(dto.getName());
        course.setSubject(dto.getSubject());
        course.setInstructorName(dto.getInstructorName());
        course.setFee(dto.getFee());
        course.setSchedule(dto.getSchedule());
        course.setDuration(dto.getDuration());
        course.setDescription(dto.getDescription());
        Course saved = repo.save(course);
        return toDto(saved);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Course not found: " + id);
        repo.deleteById(id);
    }

    private Course toEntity(CourseCreateDto dto) {
        Course c = new Course();
        c.setName(dto.getName());
        c.setSubject(dto.getSubject());
        c.setInstructorName(dto.getInstructorName());
        c.setFee(dto.getFee());
        c.setSchedule(dto.getSchedule());
        c.setDuration(dto.getDuration());
        c.setDescription(dto.getDescription());
        return c;
    }

    private CourseDto toDto(Course c) {
        CourseDto d = new CourseDto();
        d.setId(c.getId());
        d.setName(c.getName());
        d.setSubject(c.getSubject());
        d.setInstructorName(c.getInstructorName());
        d.setFee(c.getFee());
        d.setSchedule(c.getSchedule());
        d.setDuration(c.getDuration());
        d.setDescription(c.getDescription());
        d.setCreatedAt(c.getCreatedAt());
        return d;
    }
}
