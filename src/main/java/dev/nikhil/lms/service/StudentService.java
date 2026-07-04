package dev.nikhil.lms.service;

import dev.nikhil.lms.model.Student;
import dev.nikhil.lms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repo;

    public List<Student> getStudents(){
        return repo.findAll();
    }

    public Optional<Student> getStudentByID(UUID id){
        return repo.findById(id);
    }

    public Student saveStudent(Student student){
        return repo.save(student);
    }


}
