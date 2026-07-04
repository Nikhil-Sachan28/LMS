package dev.nikhil.lms.controller;

import dev.nikhil.lms.model.Student;
import dev.nikhil.lms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    List<Student> getStudents(){
        return service.getStudents();
    }

    @PostMapping
    Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/{id}")
    Optional<Student> getStudentById(@PathVariable UUID id){
        return service.getStudentByID(id);
    }
}
