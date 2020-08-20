package ru.coffeetearea.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.coffeetearea.model.Role;

import java.util.Collection;
import java.util.Collections;

@Getter
@AllArgsConstructor
public class JwtUser implements UserDetails {

    private Long id;

    private String name;

    private String lastName;

    private String login;

    private String password;

    private String mail;

    private boolean isDeleted;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

    /**
     * Возвращает авторизованного пользователя
     */
    public static JwtUser getCurrentUser() {
        return (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * Возвращает ID авторизованного пользователя
     */
    public static Long getCurrentUserID() {
        return JwtUser.getCurrentUser().getId();
    }

    @Override
    public String getUsername() {
        return login;
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