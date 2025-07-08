package com.lawfirm.lawfirm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "lawyers")
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private String email;
    private String specialization;
    private int experience;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public int getExperience() { return experience; }

    public void setExperience(int experience) { this.experience = experience; }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
