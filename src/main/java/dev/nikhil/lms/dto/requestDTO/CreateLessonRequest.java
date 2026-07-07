package dev.nikhil.lms.dto.requestDTO;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateLessonRequest {
    String title;
    String content;
    int durationInMinutes;
    UUID moduleId;
}
