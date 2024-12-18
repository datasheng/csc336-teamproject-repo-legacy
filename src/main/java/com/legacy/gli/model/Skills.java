package com.legacy.gli.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skillid")
    private Integer skillId;

    @ManyToOne
    @JoinColumn(name = "categoryid", nullable = false)
    private Skill_Categories categoryId;

    @Column(name = "skill_name", nullable = false, length = 50)
    private String skillName;

    // Getters and Setters
    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Skill_Categories getCategoryID() {
        return categoryId;
    }

    public void setCategory(Skill_Categories categoryId) {
        this.categoryId = categoryId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

}
