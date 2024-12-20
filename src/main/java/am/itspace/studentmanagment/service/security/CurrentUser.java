package am.itspace.studentmanagment.service.security;

import am.itspace.studentmanagment.entity.LoginUser;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private LoginUser user;
    public CurrentUser(LoginUser user){
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getLoginUserType().name()));
        this.user=user;
    }

    public LoginUser getUser(){
        return user;
    }
}
