package com.legacy.gli.controller;

import com.legacy.gli.model.Companies;
import com.legacy.gli.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {

    private final CompaniesService companiesService;

    @Autowired
    public CompaniesController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    // Get all companies
    @GetMapping
    public ResponseEntity<List<Companies>> getAllCompanies() {
        return new ResponseEntity<>(companiesService.getAllCompanies(), HttpStatus.OK);
    }

    // Get a company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Companies> getCompanyById(@PathVariable Integer id) {
        return companiesService.getCompanyById(id)
                .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new company
    @PostMapping
    public ResponseEntity<Companies> addCompany(@RequestBody Companies company) {
        return new ResponseEntity<>(companiesService.addCompany(company), HttpStatus.CREATED);
    }

    // Update a company
    @PutMapping("/{id}")
    public ResponseEntity<Companies> updateCompany(@PathVariable Integer id, @RequestBody Companies companyDetails) {
        try {
            Companies updatedCompany = companiesService.updateCompany(id, companyDetails);
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a company
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id) {
        boolean deleted = companiesService.deleteCompany(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Find companies by industry
    @GetMapping("/industry/{industry}")
    public ResponseEntity<List<Companies>> findByIndustry(@PathVariable String industry) {
        return new ResponseEntity<>(companiesService.findByIndustry(industry), HttpStatus.OK);
    }

    // Find companies by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Companies>> findByLocation(@PathVariable String location) {
        return new ResponseEntity<>(companiesService.findByLocation(location), HttpStatus.OK);
    }

    // Find companies by company name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Companies>> findByCompanyName(@PathVariable String name) {
        return new ResponseEntity<>(companiesService.findByCompanyName(name), HttpStatus.OK);
    }
}
