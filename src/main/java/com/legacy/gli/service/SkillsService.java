package com.legacy.gli.service;

import com.legacy.gli.model.Skills;
import com.legacy.gli.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    private final SkillsRepository repository;

    @Autowired
    public SkillsService(SkillsRepository repository) {
        this.repository = repository;
    }

    // Add a new skill
    public Skills addSkill(Skills skill) {
        return repository.save(skill);
    }

    // Get all skills
    public List<Skills> getAllSkills() {
        return repository.findAll();
    }

    // Get skill by ID
    public Optional<Skills> getSkillById(Integer skillId) {
        return repository.findById(skillId);
    }

    // Get skills by category ID
    public List<Skills> getSkillsByCategoryId(Integer categoryId) {
        return repository.findByCategoryIdCategoryId(categoryId);
    }

    // Search skills by skill name
    public List<Skills> searchSkillsByName(String skillName) {
        return repository.findBySkillNameContaining(skillName);
    }

    // Delete a skill by ID
    public void deleteSkillById(Integer skillId) {
        repository.deleteById(skillId);
    }
}
