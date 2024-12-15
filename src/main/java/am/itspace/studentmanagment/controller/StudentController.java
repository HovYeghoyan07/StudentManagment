package am.itspace.studentmanagment.controller;

import am.itspace.studentmanagment.entity.Lesson;
import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.service.LessonService;
import am.itspace.studentmanagment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {


    private StudentService studentService;


    private LessonService lessonService;

    @GetMapping
    public String studentPage(ModelMap modelMap){
        List<User> students = studentService.findByUserType(UserType.STUDENT);
        modelMap.put("students",students);
        return "student/students";
    }


    @GetMapping("/add")
    public String addStudentPage(ModelMap modelMap){
        List<Lesson> lessons = lessonService.findAll();
        modelMap.put("lessons",lessons);
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute User student){
        student.setUserType(UserType.STUDENT);
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        studentService.deleteById(id);
        return "redirect:/students";
    }
}
