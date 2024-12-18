package com.legacy.gli.service;

import com.legacy.gli.model.User_Skills;
import com.legacy.gli.repository.UserSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class User_SkillsService {

    private final UserSkillsRepository userSkillsRepository;

    @Autowired
    public User_SkillsService(UserSkillsRepository userSkillsRepository) {
        this.userSkillsRepository = userSkillsRepository;
    }

    // Get all UserSkills
    public List<User_Skills> getAllUserSkills() {
        return userSkillsRepository.findAll();
    }

    // Get UserSkills by ID
    public Optional<User_Skills> getUserSkillsById(Long id) {
        return userSkillsRepository.findById(id);
    }

    // Get UserSkills by UserID
    public List<User_Skills> getUserSkillsByUserId(Long userID) {
        return userSkillsRepository.findByUserUserID(userID);
    }

    // Get UserSkills by SkillID
    public List<User_Skills> getUserSkillsBySkillId(Long skillId) {
        return userSkillsRepository.findBySkillSkillId(skillId);
    }

    // Add new UserSkills
    public User_Skills addUserSkills(User_Skills userSkills) {
        return userSkillsRepository.save(userSkills);
    }

    // Update UserSkills
    public User_Skills updateUserSkills(Long id, User_Skills updatedUserSkills) {
        return userSkillsRepository.findById(id).map(existingUserSkills -> {
            existingUserSkills.setProficiencyLevel(updatedUserSkills.getProficiencyLevel());
            existingUserSkills.setUser(updatedUserSkills.getUser());
            existingUserSkills.setSkill(updatedUserSkills.getSkill());
            return userSkillsRepository.save(existingUserSkills);
        }).orElseThrow(() -> new RuntimeException("UserSkills not found with id " + id));
    }

    // Delete UserSkills by ID
    public void deleteUserSkills(Long id) {
        userSkillsRepository.deleteById(id);
    }
}
