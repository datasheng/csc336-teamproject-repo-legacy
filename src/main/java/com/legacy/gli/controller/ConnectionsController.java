package com.legacy.gli.controller;

import com.legacy.gli.model.Connections;
import com.legacy.gli.model.Users;
import com.legacy.gli.service.ConnectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/connections")
public class ConnectionsController {

    private final ConnectionsService service;

    @Autowired
    public ConnectionsController(ConnectionsService service) {
        this.service = service;
    }

    // Add a new connection
    @PostMapping
    public ResponseEntity<Connections> addConnection(@RequestBody Connections connection) {
        return ResponseEntity.ok(service.addConnection(connection));
    }

    // Get all followers of a user
    @GetMapping("/followers/{userId}")
    public ResponseEntity<List<Connections>> getFollowers(@PathVariable Integer userId) {
        Users user = new Users();
        user.setUserID(userId);
        return ResponseEntity.ok(service.getFollowers(user));
    }

    // Get all users a specific user is following
    @GetMapping("/following/{followerId}")
    public ResponseEntity<List<Connections>> getFollowing(@PathVariable Integer followerId) {
        Users follower = new Users();
        follower.setUserID(followerId);
        return ResponseEntity.ok(service.getFollowing(follower));
    }

    // Remove a connection
    @DeleteMapping
    public ResponseEntity<String> removeConnection(@RequestParam Integer userId, @RequestParam Integer followerId) {
        Users user = new Users();
        user.setUserID(userId);

        Users follower = new Users();
        follower.setUserID(followerId);

        service.removeConnection(user, follower);
        return ResponseEntity.ok("Connection removed successfully");
    }
}
