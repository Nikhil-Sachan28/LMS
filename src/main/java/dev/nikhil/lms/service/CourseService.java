package dev.nikhil.lms.service;

import dev.nikhil.lms.dto.CreateCourseRequest;
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
        System.out.println(course.getInstructorId());
        Instructor instructor = null;
        if(course.getInstructorId() != null)
            instructor = instructorRepo
                .findById(course.getInstructorId()).get();

        Course course1 = new Course();
        course1.setTitle(course.getTitle());
        course1.setPrice(course.getPrice());
        course1.setInstructor(instructor);
        course1.setDescription(course.getDescription());

        return courseRepo.save(course1);
    }

    public void deleteCourse(UUID id){
        courseRepo.findById(id);
    }

    public List<Course> saveBulkCourse(List<CreateCourseRequest> courses){
        List<Course> bulkCourses = new ArrayList<>();
        for(CreateCourseRequest course: courses){
            Instructor instructor = null;
            if(course.getInstructorId() != null)
                instructor = instructorRepo
                        .findById(course.getInstructorId()).get();

            Course course1 = new Course();
            course1.setTitle(course.getTitle());
            course1.setPrice(course.getPrice());
            course1.setInstructor(instructor);
            course1.setDescription(course.getDescription());
            bulkCourses.add(course1);
        }
        return courseRepo.saveAll(bulkCourses);
    }
}
