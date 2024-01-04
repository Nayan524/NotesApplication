package com.assignment.notes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import com.assignment.notes.Entities.Note;
import com.assignment.notes.Repositories.NoteRepository;

import java.util.function.Predicate;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public List<Note> getNotes(String username) {
        return repository.findByUsername(username);
    }

    public void addNote(Note note, String username) {
        note.setUsername(username);
        note.setTargetDate(LocalDate.now());
        repository.save(note);
    }

}
