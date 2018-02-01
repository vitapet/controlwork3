package by.academy.control.web.security;

import by.academy.control.service.IUserService;
import by.academy.control.service.model.UserDTO;
import by.academy.control.web.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDTO user = userService.getByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        return new UserPrincipal(user);
//        return new User(user.getLogin(), user.getPassword(), true,
//                true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserDTO user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
