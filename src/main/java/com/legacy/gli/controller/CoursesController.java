package com.legacy.gli.controller;

import com.legacy.gli.model.Courses;
import com.legacy.gli.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CoursesService service;

    @Autowired
    public CoursesController(CoursesService service) {
        this.service = service;
    }

    // Create or Update a Course
    @PostMapping
    public ResponseEntity<Courses> createOrUpdateCourse(@RequestBody Courses course) {
        Courses savedCourse = service.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    // Get All Courses
    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // Get Course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Courses>> getCourseById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCourseById(id));
    }

    // Get Courses by Course Name
    @GetMapping("/name/{courseName}")
    public ResponseEntity<List<Courses>> getCoursesByName(@PathVariable String courseName) {
        return ResponseEntity.ok(service.getCoursesByName(courseName));
    }

    // Get Courses by Points
    @GetMapping("/points/{points}")
    public ResponseEntity<List<Courses>> getCoursesByPoints(@PathVariable Integer points) {
        return ResponseEntity.ok(service.getCoursesByPoints(points));
    }

    // Delete a Course
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
        service.deleteCourse(id);
        return ResponseEntity.ok("Course with ID " + id + " deleted successfully.");
    }
}
