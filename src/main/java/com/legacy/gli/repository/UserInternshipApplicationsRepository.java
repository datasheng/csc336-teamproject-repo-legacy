package com.legacy.gli.repository;

import com.legacy.gli.model.User_Internship_Applications;
import com.legacy.gli.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInternshipApplicationsRepository extends JpaRepository<User_Internship_Applications, Integer> {

    // Find applications by User ID
    List<User_Internship_Applications> findByUserUserID(Integer userID);

    // Find applications by Internship ID
    List<User_Internship_Applications> findByInternshipInternshipId(Integer internshipId);

    // Find applications by Application Status
    List<User_Internship_Applications> findByApplicationStatus(ApplicationStatus status);
}
