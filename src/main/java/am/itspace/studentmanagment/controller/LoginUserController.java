package am.itspace.studentmanagment.controller;

import am.itspace.studentmanagment.entity.LoginUser;
import am.itspace.studentmanagment.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class LoginUserController {


    private LoginUserService loginUserService;
    private final PasswordEncoder passwordEncoder;

@GetMapping("/register")
public String registerPage(){
    return "register";
}


    @PostMapping("/add")
    public String addUser(@ModelAttribute LoginUser loginUser){
        Optional<LoginUser> byEmail = loginUserService.findByEmail(loginUser.getEmail());
        if (byEmail.isEmpty()){
            loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));
            loginUserService.save(loginUser);
        }
        return "redirect:/";
    }


}
