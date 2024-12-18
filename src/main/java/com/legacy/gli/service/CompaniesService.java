package com.legacy.gli.service;

import com.legacy.gli.model.Companies;
import com.legacy.gli.repository.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesService {

    private final CompaniesRepository companiesRepository;

    @Autowired
    public CompaniesService(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    // Get all companies
    public List<Companies> getAllCompanies() {
        return companiesRepository.findAll();
    }

    // Get company by ID
    public Optional<Companies> getCompanyById(Integer id) {
        return companiesRepository.findById(id);
    }

    // Add a new company
    public Companies addCompany(Companies company) {
        return companiesRepository.save(company);
    }

    // Update an existing company
    public Companies updateCompany(Integer id, Companies companyDetails) {
        return companiesRepository.findById(id).map(existingCompany -> {
            existingCompany.setCompanyName(companyDetails.getCompanyName());
            existingCompany.setDescription(companyDetails.getDescription());
            existingCompany.setIndustry(companyDetails.getIndustry());
            existingCompany.setLocation(companyDetails.getLocation());
            existingCompany.setWebsite(companyDetails.getWebsite());
            existingCompany.setLogo(companyDetails.getLogo());
            existingCompany.setUpdatedAt(companyDetails.getUpdatedAt());
            return companiesRepository.save(existingCompany);
        }).orElseThrow(() -> new RuntimeException("Company not found with ID: " + id));
    }

    // Delete a company
    public boolean deleteCompany(Integer id) {
        return companiesRepository.findById(id).map(company -> {
            companiesRepository.delete(company);
            return true;
        }).orElse(false);
    }

    // Find companies by industry
    public List<Companies> findByIndustry(String industry) {
        return companiesRepository.findByIndustry(industry);
    }

    // Find companies by location
    public List<Companies> findByLocation(String location) {
        return companiesRepository.findByLocation(location);
    }

    // Find companies by company name (partial match)
    public List<Companies> findByCompanyName(String name) {
        return companiesRepository.findByCompanyNameContaining(name);
    }
}
