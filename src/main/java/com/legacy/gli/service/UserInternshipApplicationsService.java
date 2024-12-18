package com.legacy.gli.service;

import com.legacy.gli.model.User_Internship_Applications;
import com.legacy.gli.enums.ApplicationStatus;
import com.legacy.gli.repository.UserInternshipApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInternshipApplicationsService {

    private final UserInternshipApplicationsRepository repository;

    @Autowired
    public UserInternshipApplicationsService(UserInternshipApplicationsRepository repository) {
        this.repository = repository;
    }

    // Create or Update an Application
    public User_Internship_Applications saveApplication(User_Internship_Applications application) {
        return repository.save(application);
    }

    // Get all Applications
    public List<User_Internship_Applications> getAllApplications() {
        return repository.findAll();
    }

    // Get Applications by User ID
    public List<User_Internship_Applications> getApplicationsByUserID(Integer userID) {
        return repository.findByUserUserID(userID);
    }

    // Get Applications by Internship ID
    public List<User_Internship_Applications> getApplicationsByInternshipID(Integer internshipId) {
        return repository.findByInternshipInternshipId(internshipId);
    }

    // Get Applications by Status
    public List<User_Internship_Applications> getApplicationsByStatus(ApplicationStatus status) {
        return repository.findByApplicationStatus(status);
    }

    // Get Application by ID
    public Optional<User_Internship_Applications> getApplicationById(Integer id) {
        return repository.findById(id);
    }

    // Delete an Application
    public void deleteApplication(Integer id) {
        repository.deleteById(id);
    }
}
