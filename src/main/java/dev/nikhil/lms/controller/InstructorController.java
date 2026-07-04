package dev.nikhil.lms.controller;

import dev.nikhil.lms.model.Instructor;
import dev.nikhil.lms.service.InstructorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService service;

    @PostMapping
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return service.saveInstructor(instructor);
    }

    @GetMapping
    public List<Instructor> getInstructors(){
        return service.getInstructors();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable UUID id){
        service.deleteInstructor(id);
        return ResponseEntity.ok("Instructor deleted successfully");
    }
}
