package com.legacy.gli.repository;

import com.legacy.gli.model.UserCareerGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCareerGoalsRepository extends JpaRepository<UserCareerGoals, Integer> {
    // Custom query method to find goals by user ID
    List<UserCareerGoals> findByUserUserID(Integer userID);

    // Custom query method to find goals by career path ID
    List<UserCareerGoals> findByCareerPathCareerPathID(Integer careerPathID);
}
