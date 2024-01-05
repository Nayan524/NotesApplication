package com.assignment.notes.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private int Id;

    private String username;
    private LocalDate birthDate;
    private String mobileNumber;

    @OneToMany(mappedBy = "username")
    @JsonIgnore
    private List<Note> notes;

    public Users() {

    }

    public Users(int id, String username, LocalDate birthDate, String mobileNumber, List<Note> notes) {
        Id = id;
        this.username = username;
        this.birthDate = birthDate;
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
