package org.example.springboot.services;

import org.example.springboot.entity.UserEntity;
import org.example.springboot.repositoriey.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository UserRepository;

    public CustomUserDetailsService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = UserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}