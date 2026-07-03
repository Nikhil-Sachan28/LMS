package dev.nikhil.lms.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student extends User{
    String collegeName;
    int graduationYear;

}
