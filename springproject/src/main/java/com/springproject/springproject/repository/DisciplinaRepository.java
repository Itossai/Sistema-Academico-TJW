package com.springproject.springproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {

    Optional<Disciplina> findByCodigo(String codigo);
}
