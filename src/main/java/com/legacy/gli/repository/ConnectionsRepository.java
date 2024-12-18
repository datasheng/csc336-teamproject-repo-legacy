package com.legacy.gli.repository;

import com.legacy.gli.model.Connections;
import com.legacy.gli.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, Integer> {

    // Find all followers of a user
    List<Connections> findByUser(Users user);

    // Find all users that a specific user is following
    List<Connections> findByFollower(Users follower);

    // Check if a connection exists between two users
    boolean existsByUserAndFollower(Users user, Users follower);

    // Delete a specific connection between two users
    void deleteByUserAndFollower(Users user, Users follower);
}
