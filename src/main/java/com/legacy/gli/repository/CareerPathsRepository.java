package com.legacy.gli.repository;

import com.legacy.gli.model.CareerPaths;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerPathsRepository extends JpaRepository<CareerPaths, Integer> {

    // Custom query to find a career path by its name
    CareerPaths findByCareerName(String careerName);
}
