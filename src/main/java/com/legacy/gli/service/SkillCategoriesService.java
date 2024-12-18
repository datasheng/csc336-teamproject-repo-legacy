package com.legacy.gli.service;

import com.legacy.gli.model.Skill_Categories;
import com.legacy.gli.repository.SkillCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoriesService {

    private final SkillCategoriesRepository skillCategoriesRepository;

    @Autowired
    public SkillCategoriesService(SkillCategoriesRepository skillCategoriesRepository) {
        this.skillCategoriesRepository = skillCategoriesRepository;
    }

    public List<Skill_Categories> getAllCategories() {
        return skillCategoriesRepository.findAll();
    }

    public Skill_Categories getCategoryById(Integer id) {
        return skillCategoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public List<Skill_Categories> searchCategoriesByName(String name) {
        return skillCategoriesRepository.findByCategoryNameContaining(name);
    }

    public Skill_Categories saveCategory(Skill_Categories category) {
        return skillCategoriesRepository.save(category);
    }

    public Skill_Categories updateCategory(Integer id, Skill_Categories updatedCategory) {
        Skill_Categories existingCategory = getCategoryById(id);
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        existingCategory.setDescription(updatedCategory.getDescription());
        return skillCategoriesRepository.save(existingCategory);
    }

    public void deleteCategory(Integer id) {
        skillCategoriesRepository.deleteById(id);
    }
}
