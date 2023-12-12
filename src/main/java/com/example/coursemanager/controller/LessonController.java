package com.example.coursemanager.controller;

import com.example.coursemanager.model.Block;
import com.example.coursemanager.model.Course;
import com.example.coursemanager.model.Lesson;
import com.example.coursemanager.service.CourseService;
import com.example.coursemanager.service.LessonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;
    @PostMapping("delete/{id}")
    public String deleteLesson(@PathVariable Long id) {
            lessonService.deleteLesson(id);
            return "redirect:/lessons/management";
    }


    @GetMapping("/management")
    public String getAllLessons(Model model) {
        List<Lesson> lessonsList;

        lessonsList = lessonService.getAllLessons();
        model.addAttribute("lessonsList", lessonsList);

        return "admin/lesson/LessonManagement";
    }

    @GetMapping("manage/{lessonId}")
    public String getLessonById(@PathVariable Long lessonId, Model model) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        model.addAttribute("lesson", lesson);
        return "admin/lesson/LessonInformation";
    }

}
