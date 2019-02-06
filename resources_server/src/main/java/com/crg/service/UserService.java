package com.crg.service;

import com.crg.model.User;
import com.crg.model.dto.UserDto;
import com.crg.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);

    public User addUser(UserDto userDto) {
        User savedUser = User
                .builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPlainTextPassword()))
                .email(userDto.getEmail())
                .accountActivated(false)
                .build();

        return null;
    }
}
