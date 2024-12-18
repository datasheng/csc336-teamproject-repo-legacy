package com.legacy.gli.controller;

import com.legacy.gli.model.Internships;
import com.legacy.gli.service.InternshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/internships")
public class InternshipsController {

    private final InternshipsService internshipsService;

    @Autowired
    public InternshipsController(InternshipsService internshipsService) {
        this.internshipsService = internshipsService;
    }

    // Get all internships
    @GetMapping
    public ResponseEntity<List<Internships>> getAllInternships() {
        List<Internships> internships = internshipsService.getAllInternships();
        return new ResponseEntity<>(internships, HttpStatus.OK);
    }

    // Get internship by ID
    @GetMapping("/{id}")
    public ResponseEntity<Internships> getInternshipById(@PathVariable Integer id) {
        Optional<Internships> internship = internshipsService.getInternshipById(id);
        return internship.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update an internship
    @PostMapping
    public ResponseEntity<Internships> createOrUpdateInternship(@RequestBody Internships internship) {
        Internships savedInternship = internshipsService.saveInternship(internship);
        return new ResponseEntity<>(savedInternship, HttpStatus.CREATED);
    }

    // Delete internship by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInternship(@PathVariable Integer id) {
        boolean deleted = internshipsService.deleteInternship(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Find internships by company ID
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Internships>> getInternshipsByCompanyId(@PathVariable Integer companyId) {
        List<Internships> internships = internshipsService.getInternshipsByCompanyCompanyId(companyId);
        return new ResponseEntity<>(internships, HttpStatus.OK);
    }

    // Find internships by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Internships>> getInternshipsByLocation(@PathVariable String location) {
        List<Internships> internships = internshipsService.getInternshipsByLocation(location);
        return new ResponseEntity<>(internships, HttpStatus.OK);
    }

    // Find internships by title
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Internships>> getInternshipsByTitle(@PathVariable String title) {
        List<Internships> internships = internshipsService.getInternshipsByTitle(title);
        return new ResponseEntity<>(internships, HttpStatus.OK);
    }

    // Find internships by required skills
    @GetMapping("/skills/{skills}")
    public ResponseEntity<List<Internships>> getInternshipsBySkills(@PathVariable String skills) {
        List<Internships> internships = internshipsService.getInternshipsBySkills(skills);
        return new ResponseEntity<>(internships, HttpStatus.OK);
    }
}
