package com.legacy.gli.controller;

import com.legacy.gli.model.UserCareerGoals;
import com.legacy.gli.service.UserCareerGoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-career-goals")
public class UserCareerGoalsController {

    private final UserCareerGoalsService userCareerGoalsService;

    @Autowired
    public UserCareerGoalsController(UserCareerGoalsService userCareerGoalsService) {
        this.userCareerGoalsService = userCareerGoalsService;
    }

    // Get all user career goals
    @GetMapping
    public ResponseEntity<List<UserCareerGoals>> getAllCareerGoals() {
        return ResponseEntity.ok(userCareerGoalsService.getAllUserCareerGoals());
    }

    // Get a specific career goal by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserCareerGoals> getCareerGoalById(@PathVariable Integer id) {
        Optional<UserCareerGoals> careerGoal = userCareerGoalsService.getUserCareerGoalById(id);
        return careerGoal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get career goals by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserCareerGoals>> getCareerGoalsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(userCareerGoalsService.getCareerGoalsByUserId(userId));
    }

    // Get career goals by career path ID
    @GetMapping("/career-path/{careerPathId}")
    public ResponseEntity<List<UserCareerGoals>> getCareerGoalsByCareerPathId(@PathVariable Integer careerPathId) {
        return ResponseEntity.ok(userCareerGoalsService.getCareerGoalsByCareerPathId(careerPathId));
    }

    // Add a new career goal
    @PostMapping
    public ResponseEntity<UserCareerGoals> addCareerGoal(@RequestBody UserCareerGoals userCareerGoal) {
        return ResponseEntity.ok(userCareerGoalsService.saveUserCareerGoal(userCareerGoal));
    }

    // Update an existing career goal
    @PutMapping("/{id}")
    public ResponseEntity<UserCareerGoals> updateCareerGoal(@PathVariable Integer id,
            @RequestBody UserCareerGoals updatedGoal) {
        return ResponseEntity.ok(userCareerGoalsService.updateUserCareerGoal(id, updatedGoal));
    }

    // Delete a career goal by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCareerGoal(@PathVariable Integer id) {
        userCareerGoalsService.deleteUserCareerGoal(id);
        return ResponseEntity.noContent().build();
    }
}
