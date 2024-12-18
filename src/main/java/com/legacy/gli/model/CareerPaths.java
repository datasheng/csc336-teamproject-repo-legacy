package com.legacy.gli.model;

import jakarta.persistence.*;

@Entity
@Table(name = "career_paths")
public class CareerPaths {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer careerPathID;

    @Column(nullable = false, length = 50)
    private String careerName;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Getters and Setters
    public Integer getCareerPathID() {
        return careerPathID;
    }

    public void setCareerPathID(Integer careerPathID) {
        this.careerPathID = careerPathID;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
