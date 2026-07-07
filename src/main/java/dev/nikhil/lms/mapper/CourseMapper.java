package dev.nikhil.lms.mapper;

import dev.nikhil.lms.dto.requestDTO.CreateCourseRequest;
import dev.nikhil.lms.dto.responseDTO.CreateCourseResponse;
import dev.nikhil.lms.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CreateCourseRequest dto);

    CreateCourseResponse toResponse(Course course);
}
