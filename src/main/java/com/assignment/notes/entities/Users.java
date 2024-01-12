package com.assignment.notes.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private int Id;

    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private LocalDate birthDate;
    private String email;
    private String role;
    private String password;
    private String mobileNumber;

    @OneToMany(mappedBy = "username",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Note> notes;

    public Users() {

    }



    public Users(int id, String username, LocalDate birthDate, String email, String role, String password,
                 String mobileNumber, List<Note> notes) {
        Id = id;
        this.username = username;
        this.birthDate = birthDate;
        this.email = email;
        this.role = role;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.notes = notes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Note> getNotes() {
        return this.notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "User [Id=" + Id + ", username=" + username + ", birthDate=" + birthDate + ", mobileNumber="
                + mobileNumber + ", notes=" + notes + "]";
    }

}
