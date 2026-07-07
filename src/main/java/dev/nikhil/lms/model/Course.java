package dev.nikhil.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "instructor_id")
    private Instructor instructor;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    LocalDateTime updatedAt;

    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    @JsonIgnore
    List<Module> modules;
}
