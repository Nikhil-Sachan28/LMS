package dev.nikhil.lms.service;

import dev.nikhil.lms.dto.requestDTO.CreateLessonRequest;
import dev.nikhil.lms.model.Lesson;
import dev.nikhil.lms.model.Module;
import dev.nikhil.lms.repository.LessonRepository;
import dev.nikhil.lms.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final ModuleRepository moduleRepository;

    public Lesson addLesson(CreateLessonRequest lesson){
        Lesson lesson1 = new Lesson();
        lesson1.setContent(lesson.getContent());
        lesson1.setTitle(lesson.getTitle());
        lesson1.setDurationInMinutes(lesson.getDurationInMinutes());
        Optional<Module> module = moduleRepository.findById(lesson.getModuleId());
        module.ifPresent(lesson1::setModule);
        return lessonRepository.save(lesson1);
    }

    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }

    public void deleteLesson(UUID id){
        lessonRepository.deleteById(id);
    }


}
