package com.assignment.notes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.notes.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {



}
