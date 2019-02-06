package com.crg.service;

import com.crg.model.CustomUserDetails;
import com.crg.model.User;
import com.crg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usersOptional = userRepository.findByName(username);
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return new CustomUserDetails(usersOptional.get());
    }
}