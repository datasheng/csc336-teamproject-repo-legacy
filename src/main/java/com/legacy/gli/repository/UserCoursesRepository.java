package com.legacy.gli.repository;

import com.legacy.gli.model.UserCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCoursesRepository extends JpaRepository<UserCourses, Integer> {
    List<UserCourses> findByUserUserID(Integer userID);

    List<UserCourses> findByCourseCourseID(Integer courseID);
}
