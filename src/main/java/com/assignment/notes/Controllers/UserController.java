package com.assignment.notes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.assignment.notes.Entities.Note;
import com.assignment.notes.Entities.Users;
import com.assignment.notes.Services.UserService;

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

}
