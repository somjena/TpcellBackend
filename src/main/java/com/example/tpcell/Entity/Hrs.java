package com.example.tpcell.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Hr")

public class Hrs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "Username",nullable = false)
    private String Username;
    @Column(name = "Firstname")
    private String FirstName;
    @Column(name = "Lastname")
    private String  Lastname;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Company")
    private String Company;
    @Column(name = "Contact")
    private String Contact;
    @Column(name = "Password")
    private String Password;

    public Hrs() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Hrs(Long id, String username, String firstName, String lastname, String email, String company, String contact, String password) {
        this.id = id;
        Username = username;
        FirstName = firstName;
        Lastname = lastname;
        Email = email;
        Company = company;
        Contact = contact;
        Password = password;
    }
}
