package am.itspace.studentmanagment.controller;

import am.itspace.studentmanagment.entity.Lesson;
import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.service.LessonService;
import am.itspace.studentmanagment.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private LessonService lessonService;


    private TeacherService teacherService;

    @GetMapping
    public String lessonPage(ModelMap modelMap){
        List<Lesson> lessons = lessonService.findAll();
        modelMap.put("lessons",lessons);
        return "lesson/lessons";
    }


    @GetMapping("/add")
    public String addLessonPage(ModelMap modelMap){
        List<User> teachers = teacherService.findByUserType(UserType.TEACHER);
        modelMap.put("teachers",teachers);
        return "lesson/addLesson";
    }

    @PostMapping("/add")
    public String addLesson(@ModelAttribute Lesson lesson){
        lesson.setStartDate(new Date());
        lessonService.save(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/delete")
    public String deleteLesson(@RequestParam("id") int id){
        lessonService.deleteById(id);
        return "redirect:/lessons";
    }
}
