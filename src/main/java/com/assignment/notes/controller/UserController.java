package com.assignment.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.assignment.notes.entities.Note;
import com.assignment.notes.entities.Users;
import com.assignment.notes.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;



    @GetMapping("users")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("users/{id}")
    public Users getUserById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("create-user")
    public void addUser(@RequestBody Users user) {
        service.addUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteByUsername(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("user/{id}/get-notes")
    public List<Note> getAllNotes(@PathVariable int id) {
        return service.getNotes1(id);

    }

    @PostMapping("user/{id}/create-note")
    public void addNotes(@RequestBody Note note, @PathVariable int id) {
        service.addNoteForUser(note, id);
    }

    @PatchMapping("user/{id}/update")
    public void updateUser(@PathVariable int id, @RequestBody Users user){
        service.update(id,user);
    }

    @PatchMapping("user/{userId}/update-note/{noteId}")
    public void updateNoteForUser(@PathVariable int userId,@PathVariable int noteId,@RequestBody Note newNote) throws IllegalAccessException {
        service.updateNote(userId,noteId,newNote);
    }
    @DeleteMapping("user/{userId}/delete-note/{noteId}")
    public void deleteNoteForUser(@PathVariable int userId, @PathVariable int noteId){
        service.deleteNoteForUser(userId,noteId);
    }





}


