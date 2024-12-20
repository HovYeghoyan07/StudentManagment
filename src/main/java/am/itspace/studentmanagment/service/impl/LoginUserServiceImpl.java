package am.itspace.studentmanagment.service.impl;

import am.itspace.studentmanagment.entity.LoginUser;
import am.itspace.studentmanagment.repository.UserRepository;
import am.itspace.studentmanagment.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginUserServiceImpl implements LoginUserService {

    private final UserRepository userRepository;
    @Override
    public LoginUser save(LoginUser loginUser) {
        return userRepository.save(loginUser);
    }

    @Override
    public Optional<LoginUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
