package com.legacy.gli.repository;

import com.legacy.gli.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    // Custom query to find skills by category ID
    List<Skills> findByCategoryIdCategoryId(Integer categoryId);

    // Custom query to find skills by name
    List<Skills> findBySkillNameContaining(String skillName);
}
