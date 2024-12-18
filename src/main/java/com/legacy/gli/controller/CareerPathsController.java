package com.legacy.gli.controller;

import com.legacy.gli.model.CareerPaths;
import com.legacy.gli.service.CareerPathsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/career-paths")
public class CareerPathsController {

    private final CareerPathsService service;

    @Autowired
    public CareerPathsController(CareerPathsService service) {
        this.service = service;
    }

    // Add a new career path
    @PostMapping
    public ResponseEntity<CareerPaths> addCareerPath(@RequestBody CareerPaths careerPath) {
        return ResponseEntity.ok(service.addCareerPath(careerPath));
    }

    // Get all career paths
    @GetMapping
    public ResponseEntity<List<CareerPaths>> getAllCareerPaths() {
        return ResponseEntity.ok(service.getAllCareerPaths());
    }

    // Get a career path by ID
    @GetMapping("/{id}")
    public ResponseEntity<CareerPaths> getCareerPathById(@PathVariable Integer id) {
        return service.getCareerPathById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get a career path by name
    @GetMapping("/search")
    public ResponseEntity<CareerPaths> getCareerPathByName(@RequestParam String name) {
        return service.getCareerPathByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a career path
    @PutMapping("/{id}")
    public ResponseEntity<CareerPaths> updateCareerPath(
            @PathVariable Integer id,
            @RequestBody CareerPaths updatedCareerPath) {
        return ResponseEntity.ok(service.updateCareerPath(id, updatedCareerPath));
    }

    // Delete a career path
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCareerPath(@PathVariable Integer id) {
        service.deleteCareerPath(id);
        return ResponseEntity.ok("Career Path deleted successfully");
    }
}
