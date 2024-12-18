package com.legacy.gli.model;

import com.legacy.gli.enums.CompletionStatus;
import com.legacy.gli.enums.VerificationStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_courses")
public class UserCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_courseID")
    private Integer userCourseID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Courses course;

    @Enumerated(EnumType.STRING)
    @Column(name = "completion_status", nullable = false, length = 50)
    private CompletionStatus completionStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status", length = 50)
    private VerificationStatus verificationStatus;

    @Column(name = "proof_of_completion", columnDefinition = "TEXT")
    private String proofOfCompletion;

    @Column(name = "completion_date")
    private LocalDateTime completionDate;

    // Getters and Setters
    public Integer getUserCourseID() {
        return userCourseID;
    }

    public void setUserCourseID(Integer userCourseID) {
        this.userCourseID = userCourseID;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public CompletionStatus getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(CompletionStatus completionStatus) {
        this.completionStatus = completionStatus;
    }

    public VerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(VerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getProofOfCompletion() {
        return proofOfCompletion;
    }

    public void setProofOfCompletion(String proofOfCompletion) {
        this.proofOfCompletion = proofOfCompletion;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }
}
