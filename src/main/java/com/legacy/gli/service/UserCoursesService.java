package com.legacy.gli.service;

import com.legacy.gli.model.UserCourses;
import com.legacy.gli.repository.UserCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCoursesService {

    private final UserCoursesRepository userCoursesRepository;

    @Autowired
    public UserCoursesService(UserCoursesRepository userCoursesRepository) {
        this.userCoursesRepository = userCoursesRepository;
    }

    // Get all UserCourses
    public List<UserCourses> getAllUserCourses() {
        return userCoursesRepository.findAll();
    }

    // Get UserCourses by ID
    public Optional<UserCourses> getUserCoursesById(Integer id) {
        return userCoursesRepository.findById(id);
    }

    // Create or Update UserCourses
    public UserCourses saveUserCourses(UserCourses userCourses) {
        return userCoursesRepository.save(userCourses);
    }

    // Delete UserCourses by ID
    public boolean deleteUserCourses(Integer id) {
        if (userCoursesRepository.existsById(id)) {
            userCoursesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Find UserCourses by User ID
    public List<UserCourses> getUserCoursesByUserID(Integer userID) {
        return userCoursesRepository.findByUserUserID(userID);
    }

    // Find UserCourses by Course ID
    public List<UserCourses> getUserCoursesByCourseID(Integer courseID) {
        return userCoursesRepository.findByCourseCourseID(courseID);
    }
}
