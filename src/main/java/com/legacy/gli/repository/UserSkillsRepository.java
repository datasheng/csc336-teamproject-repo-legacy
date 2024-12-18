package com.legacy.gli.repository;

import com.legacy.gli.model.User_Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillsRepository extends JpaRepository<User_Skills, Long> {
    // Find all user skills by user ID
    List<User_Skills> findByUserUserID(Long userID);

    // Find all user skills by skill ID
    List<User_Skills> findBySkillSkillId(Long skillId);
}
