package com.assignment.notes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.notes.Entities.Note;
import java.util.*;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    public List<Note> findByUsername(String username);

}
