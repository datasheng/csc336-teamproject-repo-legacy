package com.legacy.gli.controller;

import com.legacy.gli.model.User_Skills;
import com.legacy.gli.service.User_SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-skills")
public class UserSkillsController {

    private final User_SkillsService userSkillsService;

    @Autowired
    public UserSkillsController(User_SkillsService userSkillsService) {
        this.userSkillsService = userSkillsService;
    }

    // Get all UserSkills
    @GetMapping
    public ResponseEntity<List<User_Skills>> getAllUserSkills() {
        List<User_Skills> userSkills = userSkillsService.getAllUserSkills();
        return new ResponseEntity<>(userSkills, HttpStatus.OK);
    }

    // Get UserSkills by ID
    @GetMapping("/{id}")
    public ResponseEntity<User_Skills> getUserSkillsById(@PathVariable Long id) {
        Optional<User_Skills> userSkills = userSkillsService.getUserSkillsById(id);
        return userSkills.map(skill -> new ResponseEntity<>(skill, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get UserSkills by User ID
    @GetMapping("/user/{userID}")
    public ResponseEntity<List<User_Skills>> getUserSkillsByUserId(@PathVariable Long userID) {
        List<User_Skills> userSkills = userSkillsService.getUserSkillsByUserId(userID);
        return new ResponseEntity<>(userSkills, HttpStatus.OK);
    }

    // Get UserSkills by Skill ID
    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<User_Skills>> getUserSkillsBySkillId(@PathVariable Long skillId) {
        List<User_Skills> userSkills = userSkillsService.getUserSkillsBySkillId(skillId);
        return new ResponseEntity<>(userSkills, HttpStatus.OK);
    }

    // Create a new UserSkills
    @PostMapping
    public ResponseEntity<User_Skills> addUserSkills(@RequestBody User_Skills userSkills) {
        User_Skills addUserSkills = userSkillsService.addUserSkills(userSkills);
        return new ResponseEntity<>(addUserSkills, HttpStatus.CREATED);
    }

    // Update an existing UserSkills
    @PutMapping("/{id}")
    public ResponseEntity<User_Skills> updateUserSkills(@PathVariable Long id, @RequestBody User_Skills userSkills) {
        User_Skills updatedUserSkills = userSkillsService.updateUserSkills(id, userSkills);
        return updatedUserSkills != null
                ? new ResponseEntity<>(updatedUserSkills, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete UserSkills by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSkills(@PathVariable Long id) {
        userSkillsService.deleteUserSkills(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
