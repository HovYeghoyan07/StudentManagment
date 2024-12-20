package am.itspace.studentmanagment.repository;

import am.itspace.studentmanagment.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<LoginUser, Integer> {
    Optional<LoginUser> findByEmail(String email);
}
