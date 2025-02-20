package com.springproject.springproject.service;

import java.util.List;

import com.springproject.springproject.entity.Aluno;

public interface AlunoService {

    List<Aluno> buscarTodos();

    Aluno buscarPorId(Long id);

    void excluirPorId(Long id);

    Aluno cadastrar(Aluno a);

    Aluno editar(Aluno a);

    Aluno buscarPorCPF(String cpf);
}
