package com.legacy.gli.controller;

import com.legacy.gli.model.Skill_Categories;
import com.legacy.gli.service.SkillCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-categories")
public class SkillCategoriesController {

    private final SkillCategoriesService skillCategoriesService;

    @Autowired
    public SkillCategoriesController(SkillCategoriesService skillCategoriesService) {
        this.skillCategoriesService = skillCategoriesService;
    }

    @GetMapping
    public ResponseEntity<List<Skill_Categories>> getAllCategories() {
        return ResponseEntity.ok(skillCategoriesService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill_Categories> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(skillCategoriesService.getCategoryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Skill_Categories>> searchCategoriesByName(@RequestParam String name) {
        return ResponseEntity.ok(skillCategoriesService.searchCategoriesByName(name));
    }

    @PostMapping
    public ResponseEntity<Skill_Categories> createCategory(@RequestBody Skill_Categories category) {
        return ResponseEntity.ok(skillCategoriesService.saveCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill_Categories> updateCategory(@PathVariable Integer id,
            @RequestBody Skill_Categories category) {
        return ResponseEntity.ok(skillCategoriesService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        skillCategoriesService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
