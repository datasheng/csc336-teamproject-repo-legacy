package com.legacy.gli.controller;

import com.legacy.gli.model.Activity_Logs;
import com.legacy.gli.service.ActivityLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogsController {

    private final ActivityLogsService service;

    @Autowired
    public ActivityLogsController(ActivityLogsService service) {
        this.service = service;
    }

    // Add a new activity log
    @PostMapping
    public ResponseEntity<Activity_Logs> addActivityLog(@RequestBody Activity_Logs log) {
        return ResponseEntity.ok(service.addLog(log));
    }

    // Get all activity logs
    @GetMapping
    public ResponseEntity<List<Activity_Logs>> getAllActivityLogs() {
        return ResponseEntity.ok(service.getAllLogs());
    }

    // Get activity log by ID
    @GetMapping("/{id}")
    public ResponseEntity<Activity_Logs> getActivityLogById(@PathVariable Integer id) {
        return service.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get logs by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Activity_Logs>> getLogsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getLogsByUserId(userId));
    }

    // Get logs by action
    @GetMapping("/action")
    public ResponseEntity<List<Activity_Logs>> getLogsByAction(@RequestParam String action) {
        return ResponseEntity.ok(service.getLogsByAction(action));
    }

    // Delete activity log by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActivityLog(@PathVariable Integer id) {
        service.deleteLogById(id);
        return ResponseEntity.ok("Activity log deleted successfully");
    }
}
