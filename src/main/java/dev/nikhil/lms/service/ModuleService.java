package dev.nikhil.lms.service;

import dev.nikhil.lms.dto.requestDTO.CreateModuleRequest;
import dev.nikhil.lms.model.Course;
import dev.nikhil.lms.model.Module;
import dev.nikhil.lms.repository.CourseRepository;
import dev.nikhil.lms.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModuleService {
    private final ModuleRepository modRepo;
    private final CourseRepository courseRepository;

    public Module addModule(CreateModuleRequest module){
        Course course = courseRepository.findById(module.getCourseId()).get();
        Module module1 = new Module();
        module1.setCourse(course);
        module1.setTitle(module.getTitle());
        module1.setOrderNumber(module.getOrderNumber());
        return modRepo.save(module1);
    }

    public List<Module> getModules(){
        return modRepo.findAll();
    }

    public void deleteModule(UUID id){
        modRepo.deleteById(id);
    }
}
