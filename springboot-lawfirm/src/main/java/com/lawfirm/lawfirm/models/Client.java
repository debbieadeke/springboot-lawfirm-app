package com.lawfirm.lawfirm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private String email;
    private String address;

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
    public String getAddress() { // ✅ Make sure getter matches the type
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
