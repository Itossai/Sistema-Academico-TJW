package com.springproject.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.entity.Professor;
import com.springproject.springproject.repository.ProfessorRepository;
import com.springproject.springproject.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professor;

    @Override
    public List<Professor> buscarTodos() {
        return professor.findAll();
    }

    @Override
    public Professor buscarPorId(Long id) {
        return professor.findById(id).orElseThrow(()->new IllegalArgumentException("Professor "+ id +" não encontrado! ") );
    }

    @Override
    public Professor cadastrar(Professor p) {
        return professor.save(p);
    }

    @Override
    public void excluirPorId(Long id) {
        professor.deleteById(id);
    }

    @Override
    public Professor editar(Professor p) {
        Professor pr = this.buscarPorId(p.getId());
        pr.setCpf(p.getCpf());
        pr.setNome(p.getNome());
        pr.setTurmas(p.getTurmas());
        return professor.save(pr);
    }

}
