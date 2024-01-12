package com.assignment.notes.services;

import com.assignment.notes.model.UserPatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import com.assignment.notes.entities.Note;
import com.assignment.notes.entities.Users;
import com.assignment.notes.repositories.NoteRepository;
import com.assignment.notes.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private NoteRepository nrepo;

    @Autowired
    private UserPatcher patcher;

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
        return u.getNotes();
    }

    public void addNoteForUser(Note note, int id) {
        Users u = repository.findById(id).get();
        note.setUsername(u);
        note.setTargetDate(LocalDate.now());
        nrepo.save(note);
    }

    public void update(int id, Users newUser){
        Users existingUser = repository.findById(id).get();
        System.out.println("-------------EXPECTED USER---------------"+existingUser.getId());
        try {
            patcher.updateUser(existingUser,newUser);
            System.out.println("----------------ALL GOOD 7---------------------");
            System.out.println("-------------------NOW the ID IS-------"+existingUser.getId());
            repository.save(existingUser);
            System.out.println("-----------------ALL GOOD 8-------------");
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
