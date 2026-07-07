package dev.nikhil.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue
    private UUID id;
    String title;
    String content;
    int durationInMinutes;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    @JsonIgnore
    Module module;
}
