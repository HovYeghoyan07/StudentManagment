package am.itspace.studentmanagment.controller;

import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {


    private TeacherService teacherService;

    @GetMapping
    public String teacherPage(ModelMap modelMap){
        List<User> teachers = teacherService.findByUserType(UserType.TEACHER);
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
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        teacherService.deleteById(id);
        return "redirect:/teachers";
    }
}
