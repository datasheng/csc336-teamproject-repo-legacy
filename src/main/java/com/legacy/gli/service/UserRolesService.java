package com.legacy.gli.service;

import com.legacy.gli.model.UserRoles;
import com.legacy.gli.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolesService {

    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserRolesService(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    // Retrieve all user roles
    public List<UserRoles> getAllRoles() {
        return userRolesRepository.findAll();
    }

    // Retrieve a role by ID
    public Optional<UserRoles> getRoleById(Integer id) {
        return userRolesRepository.findById(id);
    }

    // Add a new role
    public UserRoles addRole(UserRoles userRole) {
        return userRolesRepository.save(userRole);
    }

    // Update an existing role
    public UserRoles updateRole(Integer id, UserRoles updatedRole) {
        return userRolesRepository.findById(id).map(existingRole -> {
            existingRole.setRoleName(updatedRole.getRoleName());
            existingRole.setRoleDescription(updatedRole.getRoleDescription());
            return userRolesRepository.save(existingRole);
        }).orElseThrow(() -> new RuntimeException("Role not found with ID: " + id));
    }

    // Delete a role by ID
    public boolean deleteRole(Integer id) {
        return userRolesRepository.findById(id).map(role -> {
            userRolesRepository.delete(role);
            return true;
        }).orElse(false);
    }

    // Find roles by role name
    public List<UserRoles> findByRoleName(String roleName) {
        return userRolesRepository.findByRoleName(roleName);
    }
}
