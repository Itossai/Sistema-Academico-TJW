package com.springproject.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springproject.springproject.entity.Matricula;


public interface MatriculaRepository extends JpaRepository<Matricula,Long> {

    
}
