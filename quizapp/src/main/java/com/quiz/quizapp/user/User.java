package com.quiz.quizapp.user;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(name = "User_Sequence", sequenceName = "User_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Sequence")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "score", nullable = false)
    private int score;

    public User(){

    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
