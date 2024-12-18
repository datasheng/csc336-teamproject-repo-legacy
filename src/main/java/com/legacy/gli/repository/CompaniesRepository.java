package com.legacy.gli.repository;

import com.legacy.gli.model.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies, Integer> {

    // Custom query to find companies by industry
    List<Companies> findByIndustry(String industry);

    // Custom query to find companies by location
    List<Companies> findByLocation(String location);

    // Custom query to find companies by name
    List<Companies> findByCompanyNameContaining(String companyName);
}
