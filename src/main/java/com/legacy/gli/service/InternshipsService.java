package com.legacy.gli.service;

import com.legacy.gli.model.Internships;
import com.legacy.gli.repository.InternshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternshipsService {

    private final InternshipsRepository internshipsRepository;

    @Autowired
    public InternshipsService(InternshipsRepository internshipsRepository) {
        this.internshipsRepository = internshipsRepository;
    }

    // Get all internships
    public List<Internships> getAllInternships() {
        return internshipsRepository.findAll();
    }

    // Get internship by ID
    public Optional<Internships> getInternshipById(Integer id) {
        return internshipsRepository.findById(id);
    }

    // Create or update an internship
    public Internships saveInternship(Internships internship) {
        return internshipsRepository.save(internship);
    }

    // Delete internship by ID
    public boolean deleteInternship(Integer id) {
        if (internshipsRepository.existsById(id)) {
            internshipsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Find internships by company ID
    public List<Internships> getInternshipsByCompanyCompanyId(Integer companyId) {
        return internshipsRepository.findByCompanyCompanyId(companyId);
    }

    // Find internships by location
    public List<Internships> getInternshipsByLocation(String location) {
        return internshipsRepository.findByLocation(location);
    }

    // Find internships by title (partial match)
    public List<Internships> getInternshipsByTitle(String title) {
        return internshipsRepository.findByTitleContaining(title);
    }

    // Find internships by required skills (partial match)
    public List<Internships> getInternshipsBySkills(String skills) {
        return internshipsRepository.findByRequiredSkillsContaining(skills);
    }
}
