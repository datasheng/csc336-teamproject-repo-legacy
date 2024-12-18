package com.legacy.gli.service;

import com.legacy.gli.model.Connections;
import com.legacy.gli.model.Users;
import com.legacy.gli.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionsService {

    private final ConnectionsRepository repository;

    @Autowired
    public ConnectionsService(ConnectionsRepository repository) {
        this.repository = repository;
    }

    // Add a new connection
    public Connections addConnection(Connections connection) {
        if (!repository.existsByUserAndFollower(connection.getUser(), connection.getFollower())) {
            return repository.save(connection);
        }
        throw new RuntimeException("Connection already exists!");
    }

    // Get all followers of a user
    public List<Connections> getFollowers(Users user) {
        return repository.findByUser(user);
    }

    // Get all users a specific user is following
    public List<Connections> getFollowing(Users follower) {
        return repository.findByFollower(follower);
    }

    // Remove a connection
    public void removeConnection(Users user, Users follower) {
        repository.deleteByUserAndFollower(user, follower);
    }
}
