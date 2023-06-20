package com.bank1System.bms1.user;

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

    @Column(name = "email")
    private String email;
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(Long id, String name, String email) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
