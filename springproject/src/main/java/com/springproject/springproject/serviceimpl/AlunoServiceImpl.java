package com.springproject.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.entity.Aluno;
import com.springproject.springproject.repository.AlunoRepository;
import com.springproject.springproject.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository aluno;

    @Override
    public List<Aluno> buscarTodos(){
        return aluno.findAll();
    }

    @Override
    public Aluno buscarPorId(Long id) {
        return aluno.findById(id).orElseThrow(()-> new IllegalArgumentException("Aluno "+ id +" não encontrado! "));
        
    }

    @Override
    public void excluirPorId(Long id) {
        aluno.deleteById(id);
    }

    @Override
    public Aluno cadastrar(Aluno a) {
        return aluno.save(a);
    }

    @Override
    public Aluno editar(Aluno a) {
        Aluno al = this.buscarPorId(a.getId());
        al.setNome(a.getNome());
        al.setEmail(a.getEmail());
        al.setMatriculas(a.getMatriculas());
        return aluno.save(al);
    }

    @Override
    public Aluno buscarPorCPF(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }
        return aluno.findByCpf(cpf).orElse(null);
    }

    
}
