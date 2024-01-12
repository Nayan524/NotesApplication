package com.assignment.notes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.assignment.notes.entities.Note;
import com.assignment.notes.repositories.NoteRepository;
import com.assignment.notes.repositories.UserRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    @Autowired
    private UserRepository urep;

    public List<Note> getNotes() {
        return repository.findAll();
    }

    /*
     * public void addNote(Note note, String username) {
     * Users u = urep.findByUsername(username);
     * note.setUsername(u);
     * note.setTargetDate(LocalDate.now());
     * repository.save(note);
     * }
     * 
     * public Note getNote(int id) {
     * return repository.findById(id).get();
     * }
     * 
     * public void update(int id, Note note) {
     * Note existingNote = repository.findById(id).get();
     * existingNote.setDescription(note.getDescription());
     * repository.save(existingNote);
     * 
     * }
     * 
     * public void delete(int id) {
     * repository.deleteById(id);
     * }
     * 
     * public List<Note> findNotes(String username, String search) {
     * List<Note> notes = repository.findByUsername(username);
     * Predicate<? super Note> predicate = note ->
     * note.getDescription().contains(search);
     * return notes.stream().filter(predicate).toList();
     * 
     * }
     */

}
