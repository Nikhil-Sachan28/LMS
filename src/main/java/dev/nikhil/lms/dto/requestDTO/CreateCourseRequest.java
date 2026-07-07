package dev.nikhil.lms.dto.requestDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateCourseRequest {
    private UUID id;
    private String title;
    private String description;
    private double price;
    private UUID instructorId;
}
