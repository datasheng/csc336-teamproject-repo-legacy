package com.legacy.gli.controller;

import com.legacy.gli.model.UserCourses;
import com.legacy.gli.service.UserCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-courses")
public class UserCoursesController {

    private final UserCoursesService userCoursesService;

    @Autowired
    public UserCoursesController(UserCoursesService userCoursesService) {
        this.userCoursesService = userCoursesService;
    }

    // Get all UserCourses
    @GetMapping
    public ResponseEntity<List<UserCourses>> getAllUserCourses() {
        List<UserCourses> userCourses = userCoursesService.getAllUserCourses();
        return new ResponseEntity<>(userCourses, HttpStatus.OK);
    }

    // Get UserCourses by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserCourses> getUserCoursesById(@PathVariable Integer id) {
        Optional<UserCourses> userCourses = userCoursesService.getUserCoursesById(id);
        return userCourses.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or Update UserCourses
    @PostMapping
    public ResponseEntity<UserCourses> createOrUpdateUserCourses(@RequestBody UserCourses userCourses) {
        UserCourses savedUserCourses = userCoursesService.saveUserCourses(userCourses);
        return new ResponseEntity<>(savedUserCourses, HttpStatus.CREATED);
    }

    // Delete UserCourses by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserCourses(@PathVariable Integer id) {
        boolean isDeleted = userCoursesService.deleteUserCourses(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get UserCourses by User ID
    @GetMapping("/user/{userID}")
    public ResponseEntity<List<UserCourses>> getUserCoursesByUserID(@PathVariable Integer userID) {
        List<UserCourses> userCourses = userCoursesService.getUserCoursesByUserID(userID);
        return new ResponseEntity<>(userCourses, HttpStatus.OK);
    }

    // Get UserCourses by Course ID
    @GetMapping("/course/{courseID}")
    public ResponseEntity<List<UserCourses>> getUserCoursesByCourseID(@PathVariable Integer courseID) {
        List<UserCourses> userCourses = userCoursesService.getUserCoursesByCourseID(courseID);
        return new ResponseEntity<>(userCourses, HttpStatus.OK);
    }
}
