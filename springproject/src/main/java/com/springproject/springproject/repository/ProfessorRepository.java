package com.springproject.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}
