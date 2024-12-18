package com.legacy.gli.service;

import com.legacy.gli.model.UserCareerGoals;
import com.legacy.gli.repository.UserCareerGoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCareerGoalsService {

    private final UserCareerGoalsRepository userCareerGoalsRepository;

    @Autowired
    public UserCareerGoalsService(UserCareerGoalsRepository userCareerGoalsRepository) {
        this.userCareerGoalsRepository = userCareerGoalsRepository;
    }

    // Retrieve all career goals
    public List<UserCareerGoals> getAllUserCareerGoals() {
        return userCareerGoalsRepository.findAll();
    }

    // Retrieve a single career goal by its ID
    public Optional<UserCareerGoals> getUserCareerGoalById(Integer id) {
        return userCareerGoalsRepository.findById(id);
    }

    // Retrieve career goals by user ID
    public List<UserCareerGoals> getCareerGoalsByUserId(Integer userId) {
        return userCareerGoalsRepository.findByUserUserID(userId);
    }

    // Retrieve career goals by career path ID
    public List<UserCareerGoals> getCareerGoalsByCareerPathId(Integer careerPathId) {
        return userCareerGoalsRepository.findByCareerPathCareerPathID(careerPathId);
    }

    // Add a new career goal
    public UserCareerGoals saveUserCareerGoal(UserCareerGoals userCareerGoal) {
        return userCareerGoalsRepository.save(userCareerGoal);
    }

    // Update an existing career goal
    public UserCareerGoals updateUserCareerGoal(Integer id, UserCareerGoals updatedGoal) {
        return userCareerGoalsRepository.findById(id)
                .map(existingGoal -> {
                    existingGoal.setUser(updatedGoal.getUser());
                    existingGoal.setCareerPath(updatedGoal.getCareerPath());
                    existingGoal.setGoalDescription(updatedGoal.getGoalDescription());
                    return userCareerGoalsRepository.save(existingGoal);
                })
                .orElseThrow(() -> new RuntimeException("Goal not found with id " + id));
    }

    // Delete a career goal by its ID
    public void deleteUserCareerGoal(Integer id) {
        userCareerGoalsRepository.deleteById(id);
    }
}
