package am.itspace.studentmanagment.service;

import am.itspace.studentmanagment.entity.Lesson;
import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;

import java.util.List;

public interface StudentService {
    List<User> findByUserType(UserType userType);
    List<User> findAll();
    User save(User student);
    void deleteById(int id);
}
