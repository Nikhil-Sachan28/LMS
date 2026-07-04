package dev.nikhil.lms.service;

import dev.nikhil.lms.model.Instructor;
import dev.nikhil.lms.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstructorService {
    private final InstructorRepository repo;

    public InstructorService(InstructorRepository repo){
        this.repo = repo;
    }

    public Instructor saveInstructor(Instructor instructor){
        return repo.save(instructor);
    }

    public List<Instructor> getInstructors(){
        return repo.findAll();
    }

    public void deleteInstructor(UUID uuid){
        repo.deleteById(uuid);
    }
}
