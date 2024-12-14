package am.itspace.studentmanagment.repository;

import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<User, Integer> {
    List<User> findByUserType(UserType userType);
}
