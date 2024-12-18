package com.legacy.gli.service;

import com.legacy.gli.model.Courses;
import com.legacy.gli.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    private final CoursesRepository repository;

    @Autowired
    public CoursesService(CoursesRepository repository) {
        this.repository = repository;
    }

    // Create or Update a Course
    public Courses saveCourse(Courses course) {
        return repository.save(course);
    }

    // Get all Courses
    public List<Courses> getAllCourses() {
        return repository.findAll();
    }

    // Get Course by ID
    public Optional<Courses> getCourseById(Integer id) {
        return repository.findById(id);
    }

    // Get Courses by Course Name
    public List<Courses> getCoursesByName(String courseName) {
        return repository.findByCourseNameContainingIgnoreCase(courseName);
    }

    // Get Courses by Points
    public List<Courses> getCoursesByPoints(Integer points) {
        return repository.findByPoints(points);
    }

    // Delete a Course by ID
    public void deleteCourse(Integer id) {
        repository.deleteById(id);
    }
}
