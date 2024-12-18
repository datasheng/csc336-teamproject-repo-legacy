package com.legacy.gli.controller;

import com.legacy.gli.model.Achievements;
import com.legacy.gli.model.Users;
import com.legacy.gli.service.AchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementsController {

    private final AchievementsService achievementsService;

    @Autowired
    public AchievementsController(AchievementsService achievementsService) {
        this.achievementsService = achievementsService;
    }

    // Get all achievements
    @GetMapping
    public ResponseEntity<List<Achievements>> getAllAchievements() {
        return new ResponseEntity<>(achievementsService.getAllAchievements(), HttpStatus.OK);
    }

    // Get achievement by ID
    @GetMapping("/{id}")
    public ResponseEntity<Achievements> getAchievementById(@PathVariable Long id) {
        return achievementsService.getAchievementById(id)
                .map(achievement -> new ResponseEntity<>(achievement, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new achievement
    @PostMapping
    public ResponseEntity<Achievements> addAchievement(@RequestBody Achievements achievement) {
        return new ResponseEntity<>(achievementsService.addAchievement(achievement), HttpStatus.CREATED);
    }

    // Update an existing achievement
    @PutMapping("/{id}")
    public ResponseEntity<Achievements> updateAchievement(@PathVariable Long id,
            @RequestBody Achievements updatedAchievement) {
        try {
            Achievements achievement = achievementsService.updateAchievement(id, updatedAchievement);
            return new ResponseEntity<>(achievement, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an achievement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Long id) {
        boolean deleted = achievementsService.deleteAchievement(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Find achievements by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Achievements>> getAchievementsByUser(@PathVariable Users userId) {
        return new ResponseEntity<>(achievementsService.findByUser(userId), HttpStatus.OK);
    }

    // Find achievements by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Achievements>> getAchievementsByType(@PathVariable String type) {
        return new ResponseEntity<>(achievementsService.findByAchievementType(type), HttpStatus.OK);
    }

    // Find achievements awarded after a specific date
    @GetMapping("/date-awarded/{date}")
    public ResponseEntity<List<Achievements>> getAchievementsByDateAwarded(@PathVariable String date) {
        LocalDateTime parsedDate = LocalDateTime.parse(date);
        return new ResponseEntity<>(achievementsService.findByDateAwardedAfter(parsedDate), HttpStatus.OK);
    }
}
