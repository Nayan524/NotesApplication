package com.assignment.notes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.assignment.notes.Entities.Note;
import com.assignment.notes.Services.NoteService;

@RestController
public class NoteController {

    @Autowired
    private NoteService service;

    @GetMapping("{username}/api/notes")
    public List<Note> getNotes(@PathVariable String username) {
        return service.getNotes(username);
    }

    @PostMapping("{username}/api/notes")
    public void addNotes(@RequestBody Note note, @PathVariable String username) {
        service.addNote(note, username);
    }

}
