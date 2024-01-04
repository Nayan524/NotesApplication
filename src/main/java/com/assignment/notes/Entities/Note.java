package com.assignment.notes.Entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private int Id;

    @JsonIgnore
    private String username;

    @JsonIgnore
    private LocalDate targetDate;

    private String description;

    public Note() {

    }

    public Note(int id, String username, LocalDate targetDate, String description) {
        Id = id;
        this.username = username;
        this.targetDate = targetDate;
        this.description = description;
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

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Note [Id=" + Id + ", username=" + username + ", targetDate=" + targetDate + ", description="
                + description + "]";
    }

}
