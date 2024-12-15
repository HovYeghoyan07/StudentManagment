package am.itspace.studentmanagment.service.impl;

import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import am.itspace.studentmanagment.repository.StudentRepository;
import am.itspace.studentmanagment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public List<User> findByUserType(UserType userType) {
        return studentRepository.findByUserType(userType);
    }

    @Override
    public List<User> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public User save(User student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
studentRepository.deleteById(id);
    }
}
