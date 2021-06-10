package com.example.mhwequipment;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * In order to implement authentication (login) feature, we need to create a class of
 * subtype UserDetails (defined by Spring Security) to represent an authentication user
 * Spring Security will invoke methods in this class during the authentication process.
 */

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    @Override
    public String getPassword(){

        return user.getPassword();
    }

    @Override
    public String getUsername(){

        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    public String getDisplayName(){
        return user.getUsername();
    }


}
