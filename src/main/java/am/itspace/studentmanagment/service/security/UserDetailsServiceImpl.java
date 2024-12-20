package am.itspace.studentmanagment.service.security;

import am.itspace.studentmanagment.entity.LoginUser;
import am.itspace.studentmanagment.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final LoginUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LoginUser>  byEmail=(userService.findByEmail(username));
        if (byEmail.isPresent()){
            return new CurrentUser(byEmail.get());
        }
        throw new UsernameNotFoundException("User with"+username+"does not exist");
    }
}
