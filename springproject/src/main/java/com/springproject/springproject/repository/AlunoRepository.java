package com.springproject.springproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.springproject.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{

    Optional<Aluno> findByCpf(String cpf);
}
