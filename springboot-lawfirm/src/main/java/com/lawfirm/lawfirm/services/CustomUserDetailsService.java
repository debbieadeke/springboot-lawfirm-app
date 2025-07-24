package com.lawfirm.lawfirm.services;

import com.lawfirm.lawfirm.models.User;
import com.lawfirm.lawfirm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.User.UserBuilder;
// import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = userRepository.findByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Build Spring Security user
        return org.springframework.security.core.userdetails.User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword()) // hashed password in DB
                .roles(appUser.getRole()) // e.g., ADMIN or LAWYER
                .build();
    }
}
