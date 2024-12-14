package am.itspace.studentmanagment.controller;

import am.itspace.studentmanagment.entity.Lesson;
import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.repository.LessonRepository;
import am.itspace.studentmanagment.repository.StudentRepository;
import am.itspace.studentmanagment.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public String lessonPage(ModelMap modelMap){
        List<Lesson> lessons = lessonRepository.findAll();
        modelMap.put("lessons",lessons);
        return "lesson/lessons";
    }


    @GetMapping("/add")
    public String addLessonPage(ModelMap modelMap){
        List<User> teachers = teacherRepository.findByUserType(UserType.TEACHER);
        modelMap.put("teachers",teachers);
        return "lesson/addLesson";
    }

    @PostMapping("/add")
    public String addLesson(@ModelAttribute Lesson lesson){
        lesson.setStartDate(new Date());
        lessonRepository.save(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/delete")
    public String deleteLesson(@RequestParam("id") int id){
        lessonRepository.deleteById(id);
        return "redirect:/lessons";
    }
}
