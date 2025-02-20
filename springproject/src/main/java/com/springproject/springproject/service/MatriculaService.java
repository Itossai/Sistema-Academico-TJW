package com.springproject.springproject.service;

import java.util.List;

import com.springproject.springproject.entity.Matricula;


public interface MatriculaService {

    List<Matricula> buscarTodos();

    Matricula buscarPorId(Long id);

    Matricula cadastrar(Matricula m);

    void excluirPorId(Long id);

    Matricula editar(Matricula m);

}
