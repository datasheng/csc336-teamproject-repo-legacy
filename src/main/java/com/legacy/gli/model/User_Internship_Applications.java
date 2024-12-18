package com.legacy.gli.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.legacy.gli.enums.ApplicationStatus;

@Entity
@Table(name = "user_internship_applications")
public class User_Internship_Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationid")
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "internshipid", nullable = false)
    private Internships internship;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status", nullable = false)
    private ApplicationStatus applicationStatus;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    @Column(name = "status_change_timestamp")
    private LocalDateTime statusChangeTimestamp;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

    // Getters and Setters

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Internships getInternship() {
        return internship;
    }

    public void setInternship(Internships internship) {
        this.internship = internship;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getStatusChangeTimestamp() {
        return statusChangeTimestamp;
    }

    public void setStatusChangeTimestamp(LocalDateTime statusChangeTimestamp) {
        this.statusChangeTimestamp = statusChangeTimestamp;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}
