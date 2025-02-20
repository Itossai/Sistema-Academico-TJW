package com.springproject.springproject.service;

import java.util.List;


import com.springproject.springproject.entity.Semestre;

public interface SemestreService {

    List<Semestre> buscarTodos();

    Semestre buscarPorId(Long id);

    Semestre cadastrar(Semestre s);

    void excluirPorId(Long id);

    Semestre editar(Semestre s);
}
