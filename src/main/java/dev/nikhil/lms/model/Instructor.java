package dev.nikhil.lms.model;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Instructor extends User{
    String specialization;
    int experienceYears;

    @OneToMany(mappedBy = "instructor")
    List<Course> courses;
}
