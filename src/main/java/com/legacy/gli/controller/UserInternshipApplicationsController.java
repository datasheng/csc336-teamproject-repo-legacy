package com.legacy.gli.controller;

import com.legacy.gli.model.User_Internship_Applications;
import com.legacy.gli.enums.ApplicationStatus;
import com.legacy.gli.service.UserInternshipApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class UserInternshipApplicationsController {

    private final UserInternshipApplicationsService service;

    @Autowired
    public UserInternshipApplicationsController(UserInternshipApplicationsService service) {
        this.service = service;
    }

    // Create or Update an Application
    @PostMapping
    public ResponseEntity<User_Internship_Applications> createOrUpdateApplication(
            @RequestBody User_Internship_Applications application) {
        User_Internship_Applications savedApplication = service.saveApplication(application);
        return ResponseEntity.ok(savedApplication);
    }

    // Get All Applications
    @GetMapping
    public ResponseEntity<List<User_Internship_Applications>> getAllApplications() {
        return ResponseEntity.ok(service.getAllApplications());
    }

    // Get Applications by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<User_Internship_Applications>> getApplicationsByUserID(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getApplicationsByUserID(userId));
    }

    // Get Applications by Internship ID
    @GetMapping("/internship/{internshipId}")
    public ResponseEntity<List<User_Internship_Applications>> getApplicationsByInternshipID(
            @PathVariable Integer internshipId) {
        return ResponseEntity.ok(service.getApplicationsByInternshipID(internshipId));
    }

    // Get Applications by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<User_Internship_Applications>> getApplicationsByStatus(
            @PathVariable ApplicationStatus status) {
        return ResponseEntity.ok(service.getApplicationsByStatus(status));
    }

    // Get Application by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User_Internship_Applications>> getApplicationById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getApplicationById(id));
    }

    // Delete an Application
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Integer id) {
        service.deleteApplication(id);
        return ResponseEntity.ok("Application with ID " + id + " deleted successfully");
    }
}
