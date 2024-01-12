package com.assignment.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.assignment.notes.entities.Note;
import com.assignment.notes.services.NoteService;

@RestController
public class NoteController {

    @Autowired
    private NoteService service;

    @GetMapping("api/notes")
    public List<Note> getNotes() {
        return service.getNotes();
    }

    /*
     * @GetMapping("{username}/api/notes/{id}")
     * public Note getNote(@PathVariable int id) {
     * return service.getNote(id);
     * }
     * 
     * @PutMapping("{username}/api/notes/{id}")
     * public void update(@PathVariable int id, @RequestBody Note note) {
     * service.update(id, note);
     * }
     * 
     * @DeleteMapping("{username}/api/notes/{id}")
     * public void deleteById(@PathVariable int id) {
     * service.delete(id);
     * }
     */

    /*
     * public List<Note> search(@PathVariable String username, @RequestParam("q")
     * String search) {
     * return service.findNotes(username, search);
     * }
     */

}
