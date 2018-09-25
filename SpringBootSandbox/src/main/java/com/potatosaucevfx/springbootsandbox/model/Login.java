package com.potatosaucevfx.springbootsandbox.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
public class Login implements UserDetails {

    private String email;
    private String password;
    private boolean enabled;
    private User userData;

    public Login(String email, String password, boolean enabled, User user) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.userData = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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

    public User getUserData() {
        return userData;
    }

    public void setUserData(User userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "Login{" + "email=" + email + ", password=" + password + ", enabled=" + enabled + ", userData=" + userData + '}';
    }

}
