package dev.nikhil.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
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

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    @JsonIgnore
    List<Course> courses;
}
