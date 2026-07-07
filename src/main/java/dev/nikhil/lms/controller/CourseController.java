package dev.nikhil.lms.controller;

import dev.nikhil.lms.dto.requestDTO.CreateCourseRequest;
import dev.nikhil.lms.model.Course;
import dev.nikhil.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;

    @PostMapping
    public Course postCourse(@RequestBody CreateCourseRequest course){
        return service.saveCourse(course);
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable UUID id){
        return service.getCourseById(id);
    }

    @GetMapping
    public Page<Course> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String order
            ){
        return service.getCourses(page, size, sortBy, order);
    }

    @PutMapping
    public Course updateCourse(@RequestBody CreateCourseRequest course){
        return service.saveCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable UUID id){
        service.deleteCourse(id);
    }

    @PostMapping("/bulk")
    public List<Course> postBulkCourse(@RequestBody List<CreateCourseRequest> course){
        return service.saveBulkCourse(course);
    }

}
