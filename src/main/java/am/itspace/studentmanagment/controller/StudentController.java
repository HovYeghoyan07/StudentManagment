package am.itspace.studentmanagment.controller;

import am.itspace.studentmanagment.entity.Lesson;
import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.repository.LessonRepository;
import am.itspace.studentmanagment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping
    public String studentPage(ModelMap modelMap){
        List<User> students = studentRepository.findByUserType(UserType.STUDENT);
        modelMap.put("students",students);
        return "student/students";
    }


    @GetMapping("/add")
    public String addStudentPage(ModelMap modelMap){
        List<Lesson> lessons = lessonRepository.findAll();
        modelMap.put("lessons",lessons);
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute User student){
        student.setUserType(UserType.STUDENT);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}
