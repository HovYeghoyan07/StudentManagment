package am.itspace.studentmanagment.service.impl;

import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.repository.TeacherRepository;
import am.itspace.studentmanagment.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public List<User> findByUserType(UserType userType) {
        return teacherRepository.findByUserType(userType);
    }

    @Override
    public List<User> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public User save(User teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int id) {
     teacherRepository.deleteById(id);
    }
}
