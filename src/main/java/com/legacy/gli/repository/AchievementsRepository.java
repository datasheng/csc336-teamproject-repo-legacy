package com.legacy.gli.repository;

import com.legacy.gli.model.Achievements;
import com.legacy.gli.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AchievementsRepository extends JpaRepository<Achievements, Long> {

    // Find achievements by user
    List<Achievements> findByUser(Users user);

    // Find achievements by achievement type
    List<Achievements> findByAchievementType(String achievementType);

    // Find achievements awarded after a specific date
    List<Achievements> findByDateAwardedAfter(LocalDateTime date);
}
