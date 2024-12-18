package com.legacy.gli.service;

import com.legacy.gli.model.Users;
import com.legacy.gli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve user by ID
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Retrieve user by username
    public Optional<Users> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Retrieve user by email
    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Register a new user
    public Users registerUser(Users user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use!");
        }
        return userRepository.save(user);
    }

    // Update user profile
    public Users updateUser(Long id, Users updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setLocation(updatedUser.getLocation());
            existingUser.setProfession(updatedUser.getProfession());
            existingUser.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
            existingUser.setResume(updatedUser.getResume());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // Search users by username (partial match)
    public List<Users> searchUsersByUsername(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    // Search users by location
    public List<Users> searchUsersByLocation(String location) {
        return userRepository.findByLocationContainingIgnoreCase(location);
    }

    // Search users by profession
    public List<Users> searchUsersByProfession(String profession) {
        return userRepository.findByProfessionContainingIgnoreCase(profession);
    }

}
