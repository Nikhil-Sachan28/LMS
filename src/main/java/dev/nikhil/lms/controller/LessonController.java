package dev.nikhil.lms.controller;

import dev.nikhil.lms.dto.requestDTO.CreateLessonRequest;
import dev.nikhil.lms.model.Lesson;
import dev.nikhil.lms.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public Lesson addLesson(@RequestBody CreateLessonRequest lesson){
        return lessonService.addLesson(lesson);
    }

    @GetMapping
    public List<Lesson> getLesson(){
        return lessonService.getLessons();
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable UUID id){
        lessonService.deleteLesson(id);
    }
}
