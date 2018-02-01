package by.academy.control.web.model;

import by.academy.control.service.model.UserDTO;
import by.academy.control.service.model.UserRoleDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {


    private UserDTO user;
    private Collection<SimpleGrantedAuthority> grantedAuthorities;

    public UserPrincipal(UserDTO user) {
        this.user = user;
        grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
    }

    public Long getUserId() {
        return user.getId();
    }

    public UserRoleDTO getRole() {
        return user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
