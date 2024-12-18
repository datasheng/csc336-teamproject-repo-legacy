package com.legacy.gli.repository;

import com.legacy.gli.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    // Find user by username
    Optional<Users> findByUsername(String username);

    // Find user by email
    Optional<Users> findByEmail(String email);

    // Search for users with a partial match on the username
    List<Users> findByUsernameContainingIgnoreCase(String username);

    // Search for users by location
    List<Users> findByLocationContainingIgnoreCase(String location);

    // Search for users by profession
    List<Users> findByProfessionContainingIgnoreCase(String profession);

    // Check if email already exists for registration
    boolean existsByEmail(String email);

    // Check if username already exists for registration
    boolean existsByUsername(String username);

}
