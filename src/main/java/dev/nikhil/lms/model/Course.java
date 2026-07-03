package dev.nikhil.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Setter
@Getter
public class Course {
    @Id
    UUID id;
    String title;
    String description;
    double price;

    @ManyToOne
    Instructor instructor;
    LocalDateTime createdAt;
}
