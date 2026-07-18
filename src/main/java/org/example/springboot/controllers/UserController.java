package org.example.springboot.controllers;

import org.example.springboot.Exception.ResourceNotFount;

import org.example.springboot.entity.UserEntity;
import org.example.springboot.repositoriey.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Get all users
    @GetMapping
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    // Create a new user
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFount("User not found with id " + id));
    }

    // Update user
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id,
                                 @RequestBody UserEntity user) {

        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFount("User not found with id " + id));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(
                    passwordEncoder.encode(user.getPassword())
            );
        }

        return userRepository.save(existingUser);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFount("User not found with id " + id));

        userRepository.delete(user);

        return ResponseEntity.noContent().build();
    }
}