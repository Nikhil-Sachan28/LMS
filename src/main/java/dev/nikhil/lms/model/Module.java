package dev.nikhil.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Module {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private int orderNumber;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore
    private Course course;

    @OneToMany(
            mappedBy = "module",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    List<Lesson> lessonList;
}
