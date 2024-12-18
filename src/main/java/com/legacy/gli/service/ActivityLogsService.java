package com.legacy.gli.service;

import com.legacy.gli.model.Activity_Logs;
import com.legacy.gli.repository.ActivityLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogsService {

    private final ActivityLogsRepository repository;

    @Autowired
    public ActivityLogsService(ActivityLogsRepository repository) {
        this.repository = repository;
    }

    // Add a new activity log
    public Activity_Logs addLog(Activity_Logs log) {
        return repository.save(log);
    }

    // Get all logs
    public List<Activity_Logs> getAllLogs() {
        return repository.findAll();
    }

    // Get log by ID
    public Optional<Activity_Logs> getLogById(Integer logID) {
        return repository.findById(logID);
    }

    // Get logs by user ID
    public List<Activity_Logs> getLogsByUserId(Integer userID) {
        return repository.findByUserUserID(userID);
    }

    // Get logs by action
    public List<Activity_Logs> getLogsByAction(String action) {
        return repository.findByAction(action);
    }

    // Delete a log by ID
    public void deleteLogById(Integer logID) {
        repository.deleteById(logID);
    }
}
