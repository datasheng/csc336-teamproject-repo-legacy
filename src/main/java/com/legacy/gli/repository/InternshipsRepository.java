package com.legacy.gli.repository;

import com.legacy.gli.model.Internships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipsRepository extends JpaRepository<Internships, Integer> {

    List<Internships> findByCompanyCompanyId(Integer companyId);

    List<Internships> findByLocation(String location);

    List<Internships> findByTitleContaining(String title);

    List<Internships> findByRequiredSkillsContaining(String requiredSkills);
}
