package dev.nikhil.lms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Setter
@Getter

public class Course {
    @Id
    @GeneratedValue
    UUID id;
    private String title;
    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(nullable = false, name = "instructor_id")
    private Instructor instructor;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    LocalDateTime updatedAt;
}
