package com.legacy.gli.service;

import com.legacy.gli.model.Achievements;
import com.legacy.gli.model.Users;
import com.legacy.gli.repository.AchievementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AchievementsService {

    private final AchievementsRepository achievementsRepository;

    @Autowired
    public AchievementsService(AchievementsRepository achievementsRepository) {
        this.achievementsRepository = achievementsRepository;
    }

    // Retrieve all achievements
    public List<Achievements> getAllAchievements() {
        return achievementsRepository.findAll();
    }

    // Retrieve an achievement by ID
    public Optional<Achievements> getAchievementById(Long id) {
        return achievementsRepository.findById(id);
    }

    // Add a new achievement
    public Achievements addAchievement(Achievements achievement) {
        return achievementsRepository.save(achievement);
    }

    // Update an existing achievement
    public Achievements updateAchievement(Long id, Achievements updatedAchievement) {
        return achievementsRepository.findById(id).map(existingAchievement -> {
            existingAchievement.setUser(updatedAchievement.getUser());
            existingAchievement.setAchievementType(updatedAchievement.getAchievementType());
            existingAchievement.setDescription(updatedAchievement.getDescription());
            existingAchievement.setPoints(updatedAchievement.getPoints());
            existingAchievement.setDateAwarded(updatedAchievement.getDateAwarded());
            return achievementsRepository.save(existingAchievement);
        }).orElseThrow(() -> new RuntimeException("Achievement not found with ID: " + id));
    }

    // Delete an achievement by ID
    public boolean deleteAchievement(Long id) {
        return achievementsRepository.findById(id).map(achievement -> {
            achievementsRepository.delete(achievement);
            return true;
        }).orElse(false);
    }

    // Find achievements by user
    public List<Achievements> findByUser(Users user) {
        return achievementsRepository.findByUser(user);
    }

    // Find achievements by type
    public List<Achievements> findByAchievementType(String type) {
        return achievementsRepository.findByAchievementType(type);
    }

    // Find achievements awarded after a specific date
    public List<Achievements> findByDateAwardedAfter(LocalDateTime date) {
        return achievementsRepository.findByDateAwardedAfter(date);
    }
}
