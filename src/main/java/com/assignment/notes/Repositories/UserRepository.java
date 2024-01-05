package com.assignment.notes.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.notes.Entities.Note;
import com.assignment.notes.Entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
