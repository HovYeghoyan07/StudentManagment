package am.itspace.studentmanagment.service;

import am.itspace.studentmanagment.entity.LoginUser;
import am.itspace.studentmanagment.entity.User;
import am.itspace.studentmanagment.entity.UserType;

import java.util.List;
import java.util.Optional;

public interface LoginUserService {
    LoginUser save(LoginUser loginUser);

    Optional<LoginUser> findByEmail(String email);
}
