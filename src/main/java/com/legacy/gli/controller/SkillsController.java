package com.legacy.gli.controller;

import com.legacy.gli.model.Skills;
import com.legacy.gli.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

    private final SkillsService service;

    @Autowired
    public SkillsController(SkillsService service) {
        this.service = service;
    }

    // Add a new skill
    @PostMapping
    public ResponseEntity<Skills> addSkill(@RequestBody Skills skill) {
        return ResponseEntity.ok(service.addSkill(skill));
    }

    // Get all skills
    @GetMapping
    public ResponseEntity<List<Skills>> getAllSkills() {
        return ResponseEntity.ok(service.getAllSkills());
    }

    // Get skill by ID
    @GetMapping("/{id}")
    public ResponseEntity<Skills> getSkillById(@PathVariable Integer id) {
        return service.getSkillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get skills by category ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Skills>> getSkillsByCategoryId(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(service.getSkillsByCategoryId(categoryId));
    }

    // Search skills by name
    @GetMapping("/search")
    public ResponseEntity<List<Skills>> searchSkillsByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchSkillsByName(name));
    }

    // Delete skill by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Integer id) {
        service.deleteSkillById(id);
        return ResponseEntity.ok("Skill deleted successfully");
    }
}
