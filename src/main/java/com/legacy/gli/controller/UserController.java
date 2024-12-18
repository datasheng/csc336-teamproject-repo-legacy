package com.legacy.gli.controller;

import com.legacy.gli.model.Users;
import com.legacy.gli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Allows frontend to access the backend
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update user profile
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        return ResponseEntity.ok(userService.updateUser(id, updatedUser));
    }

    // Search users by partial username
    @GetMapping("/search/username")
    public List<Users> searchUsersByUsername(@RequestParam String username) {
        return userService.searchUsersByUsername(username);
    }

    // Search users by partial location
    @GetMapping("/search/location")
    public List<Users> searchUsersByLocation(@RequestParam String location) {
        return userService.searchUsersByLocation(location);
    }

    // Search users by partial profession
    @GetMapping("/search/profession")
    public List<Users> searchUsersByProfession(@RequestParam String profession) {
        return userService.searchUsersByProfession(profession);
    }

}
