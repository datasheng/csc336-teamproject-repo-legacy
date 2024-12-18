package com.legacy.gli.repository;

import com.legacy.gli.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

    // Find by course name (case insensitive)
    List<Courses> findByCourseNameContainingIgnoreCase(String courseName);

    // Find courses by points
    List<Courses> findByPoints(Integer points);
}
