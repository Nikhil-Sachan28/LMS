package dev.nikhil.lms.service;

import dev.nikhil.lms.dto.requestDTO.CreateCourseRequest;
import dev.nikhil.lms.dto.responseDTO.CreateCourseResponse;
import dev.nikhil.lms.mapper.CourseMapper;
import dev.nikhil.lms.model.Course;
import dev.nikhil.lms.model.Instructor;
import dev.nikhil.lms.repository.CourseRepository;
import dev.nikhil.lms.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepo;
    private final InstructorRepository instructorRepo;
    private final CourseMapper mapper;

    public Page<Course> getCourses(int page, int size, String sortBy, String orderBy){
        Sort sort = orderBy.equalsIgnoreCase("desc")?
                Sort.by(sortBy).descending():
                Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(
                page,
                size,
                sort
        );
        return courseRepo.findAll(pageable);
    }

    public Optional<Course> getCourseById(UUID id){
        return courseRepo.findById(id);
    }

    public Course saveCourse(CreateCourseRequest course){

        Instructor instructor = null;
        if(course.getInstructorId() != null)
            instructor = instructorRepo.findById(course.getInstructorId()).get();

        Course course1 = mapper.toEntity(course);
        course1.setInstructor(instructor);

        return courseRepo.save(course1);
    }

    public void deleteCourse(UUID id){
        courseRepo.deleteById(id);
    }

    public List<Course> saveBulkCourse(List<CreateCourseRequest> courses){
        List<Course> bulkCourses = new ArrayList<>();
        for(CreateCourseRequest course: courses){
            Instructor instructor = null;
            if(course.getInstructorId() != null)
                instructor = instructorRepo.findById(course.getInstructorId()).get();

            Course course1 = mapper.toEntity(course);
            course1.setInstructor(instructor);
            bulkCourses.add(course1);
        }
        return courseRepo.saveAll(bulkCourses);
    }
}
