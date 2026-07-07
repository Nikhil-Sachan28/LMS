package dev.nikhil.lms.dto.requestDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateModuleRequest {
    private UUID id;
    private String title;
    private int orderNumber;
    private UUID courseId;
}
