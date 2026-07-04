package dev.nikhil.lms.repository;

import dev.nikhil.lms.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, UUID> {

}
