package com.legacy.gli.service;

import com.legacy.gli.model.CareerPaths;
import com.legacy.gli.repository.CareerPathsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerPathsService {

    private final CareerPathsRepository repository;

    @Autowired
    public CareerPathsService(CareerPathsRepository repository) {
        this.repository = repository;
    }

    // Add a new career path
    public CareerPaths addCareerPath(CareerPaths careerPath) {
        return repository.save(careerPath);
    }

    // Get all career paths
    public List<CareerPaths> getAllCareerPaths() {
        return repository.findAll();
    }

    // Get a career path by ID
    public Optional<CareerPaths> getCareerPathById(Integer careerPathID) {
        return repository.findById(careerPathID);
    }

    // Get a career path by name
    public Optional<CareerPaths> getCareerPathByName(String careerName) {
        return Optional.ofNullable(repository.findByCareerName(careerName));
    }

    // Update a career path
    public CareerPaths updateCareerPath(Integer careerPathID, CareerPaths updatedCareerPath) {
        return repository.findById(careerPathID).map(existingCareerPath -> {
            existingCareerPath.setCareerName(updatedCareerPath.getCareerName());
            existingCareerPath.setDescription(updatedCareerPath.getDescription());
            return repository.save(existingCareerPath);
        }).orElseThrow(() -> new RuntimeException("Career Path not found with ID: " + careerPathID));
    }

    // Delete a career path by ID
    public void deleteCareerPath(Integer careerPathID) {
        repository.deleteById(careerPathID);
    }
}
