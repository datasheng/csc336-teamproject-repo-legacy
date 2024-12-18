package com.legacy.gli.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_career_goals")
public class UserCareerGoals implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goalid")
    private Integer goalID;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "career_pathID", nullable = false)
    private CareerPaths careerPath;

    @Column(name = "goal_description", columnDefinition = "TEXT")
    private String goalDescription;

    // Default Constructor
    public UserCareerGoals() {
    }

    // Getters and Setters
    public Integer getGoalID() {
        return goalID;
    }

    public void setGoalID(Integer goalID) {
        this.goalID = goalID;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public CareerPaths getCareerPath() {
        return careerPath;
    }

    public void setCareerPath(CareerPaths careerPath) {
        this.careerPath = careerPath;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }
}
