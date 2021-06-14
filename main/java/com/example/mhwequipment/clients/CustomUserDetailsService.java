package com.example.mhwequipment.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * In order to tell Spring Security how to look up the user information,
 * By invoking the loadUserByUsername() method loads user data from the database
 * to authenticate the user, and if succeed, a new object of type CustomUserDetails
 * object is created to represent the authenticated user.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = repo.findByEmail(email); //the findByEmail() method that returns a single User object based on email
        if(user == null){
            throw new UsernameNotFoundException("User not Found!");
        }
        return new CustomUserDetails(user);
    }
}
