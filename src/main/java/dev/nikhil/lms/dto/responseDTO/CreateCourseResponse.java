package dev.nikhil.lms.dto.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class CreateCourseResponse {
    private UUID id;
    private String title;
    private String description;
    private double price;
}
