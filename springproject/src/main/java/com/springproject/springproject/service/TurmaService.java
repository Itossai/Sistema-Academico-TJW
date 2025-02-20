package com.springproject.springproject.service;

import java.util.List;

import com.springproject.springproject.entity.Turma;

public interface TurmaService {

    List<Turma> listarTodas() ;

    Turma buscarPorId(Long id);

    Turma cadastrar(Turma t);

    void excluirPorId(long id);

    Turma editar(Turma t);
    
}
