package com.springproject.springproject.service;

import java.util.List;

import com.springproject.springproject.entity.Professor;


public interface ProfessorService {

    List<Professor> buscarTodos();

    Professor buscarPorId(Long id);

    Professor cadastrar(Professor p);

    void excluirPorId(Long id);

    Professor editar(Professor p);
}
