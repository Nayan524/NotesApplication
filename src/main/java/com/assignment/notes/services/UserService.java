package com.assignment.notes.services;

import com.assignment.notes.model.Patcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

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
    private Patcher patcher;

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

    public void updateNote(int userId,int noteId,Note newNote) throws IllegalAccessException {
        Users user = repository.findById(userId).get();
        Note existingNote = null;
        Predicate<? super Note> predicate = note -> note.getId()==noteId;
        existingNote = user.getNotes().stream().filter(predicate).findFirst().get();
        patcher.updateNote(existingNote,newNote);

        repository.save(user);
        nrepo.save(existingNote);

    }

    public void deleteNoteForUser(int userId,int noteId){
        Users user = repository.findById(userId).get();
        Note existingNote = null;
        Predicate<? super Note> predicate = note -> note.getId()==noteId;
        existingNote = user.getNotes().stream().filter(predicate).findFirst().get();

        user.getNotes().remove(existingNote);
        repository.save(user);
        nrepo.deleteById(noteId);
    }

}
