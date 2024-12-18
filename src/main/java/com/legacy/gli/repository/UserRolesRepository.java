package com.legacy.gli.repository;

import com.legacy.gli.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {

    // Find roles by role name
    List<UserRoles> findByRoleName(String roleName);
}
