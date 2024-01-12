package com.assignment.notes.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private int Id;

    @ManyToOne()
    @JsonIgnore
    private Users username;

    private LocalDate targetDate;

    private String description;

    public Note() {

    }

    public Note(int id, Users username, LocalDate targetDate, String description) {
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

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
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
