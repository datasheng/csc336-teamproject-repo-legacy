package com.legacy.gli.repository;

import com.legacy.gli.model.Skill_Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillCategoriesRepository extends JpaRepository<Skill_Categories, Integer> {
    List<Skill_Categories> findByCategoryNameContaining(String categoryName);
}
