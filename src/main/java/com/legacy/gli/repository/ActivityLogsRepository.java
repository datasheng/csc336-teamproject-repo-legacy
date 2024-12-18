package com.legacy.gli.repository;

import com.legacy.gli.model.Activity_Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogsRepository extends JpaRepository<Activity_Logs, Integer> {
    // Custom query to find logs by user ID
    List<Activity_Logs> findByUserUserID(Integer userID);

    // Custom query to find logs by action
    List<Activity_Logs> findByAction(String action);
}
