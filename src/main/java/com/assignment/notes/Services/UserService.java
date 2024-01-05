package com.assignment.notes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import com.assignment.notes.Entities.Note;
import com.assignment.notes.Entities.Users;
import com.assignment.notes.Repositories.NoteRepository;
import com.assignment.notes.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private NoteRepository nrepo;

    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    public Users getById(int id) {
        return repository.findById(id).get();
    }

    public void addUser(Users user) {
        repository.save(user);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Note> getNotes1(int id) {

        Users u = repository.findById(id).get();
        // System.out.println("--------------------------------------------" +
        // u.getNotes().get(0));
        return u.getNotes();
    }

    public void addNoteForUser(Note note, int id) {
        Users u = repository.findById(id).get();
        note.setUsername(u);
        note.setTargetDate(LocalDate.now());
        nrepo.save(note);
        // repository.save(u);
    }

}
