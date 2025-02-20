package com.springproject.springproject.service;

import java.util.List;


import com.springproject.springproject.entity.Disciplina;

public interface DisciplinaService {
    List<Disciplina> buscarTodos();

    Disciplina buscarPorId(Long id);

    Disciplina cadastrar(Disciplina d);

    void excluirPorId(Long id);

    Disciplina editar(Disciplina d);

    Disciplina buscarPorCodigo(String codigo);
}
