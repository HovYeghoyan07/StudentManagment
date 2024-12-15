package am.itspace.studentmanagment.service;

import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;

import java.util.List;

public interface TeacherService {
    List<User> findByUserType(UserType userType);
    List<User> findAll();
    User save(User teacher);
    void deleteById(int id);
}
