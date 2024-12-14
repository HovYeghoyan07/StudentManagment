package am.itspace.studentmanagment.controller;

import am.itspace.studentmanagment.entity.Lesson;
import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public String teacherPage(ModelMap modelMap){
        List<User> teachers = teacherRepository.findByUserType(UserType.TEACHER);
        modelMap.put("teachers",teachers);
        return "teacher/teachers";
    }


    @GetMapping("/add")
    public String addTeacherPage( ){
        return "teacher/addTeacher";
    }

    @PostMapping("/add")
    public String addTeacher(@ModelAttribute User teacher){
        teacher.setUserType(UserType.TEACHER);
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        teacherRepository.deleteById(id);
        return "redirect:/teachers";
    }
}
