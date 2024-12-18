package com.legacy.gli.controller;

import com.legacy.gli.model.UserRoles;
import com.legacy.gli.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRolesController {

    private final UserRolesService userRolesService;

    @Autowired
    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    // Get all roles
    @GetMapping
    public ResponseEntity<List<UserRoles>> getAllRoles() {
        return new ResponseEntity<>(userRolesService.getAllRoles(), HttpStatus.OK);
    }

    // Get role by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRoles> getRoleById(@PathVariable Integer id) {
        return userRolesService.getRoleById(id)
                .map(role -> new ResponseEntity<>(role, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new role
    @PostMapping
    public ResponseEntity<UserRoles> addRole(@RequestBody UserRoles userRole) {
        return new ResponseEntity<>(userRolesService.addRole(userRole), HttpStatus.CREATED);
    }

    // Update an existing role
    @PutMapping("/{id}")
    public ResponseEntity<UserRoles> updateRole(@PathVariable Integer id, @RequestBody UserRoles updatedRole) {
        try {
            UserRoles role = userRolesService.updateRole(id, updatedRole);
            return new ResponseEntity<>(role, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a role
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        boolean deleted = userRolesService.deleteRole(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Find roles by role name
    @GetMapping("/name/{roleName}")
    public ResponseEntity<List<UserRoles>> getRolesByRoleName(@PathVariable String roleName) {
        return new ResponseEntity<>(userRolesService.findByRoleName(roleName), HttpStatus.OK);
    }
}
