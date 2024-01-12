package com.assignment.notes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.notes.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
