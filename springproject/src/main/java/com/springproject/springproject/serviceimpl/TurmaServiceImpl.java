package com.springproject.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.entity.Turma;
import com.springproject.springproject.repository.TurmaRepository;
import com.springproject.springproject.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {
    @Autowired
    private TurmaRepository turma;

    @Override
    public List<Turma> listarTodas() {
       return turma.findAll();
    }

    @Override
    public Turma buscarPorId(Long id) {
        return turma.findById(id).orElseThrow(()->new IllegalArgumentException("Turma "+ id +" não encontrada! "));
    }

    @Override
    public Turma cadastrar(Turma t) {
        return turma.save(t);
    }

    @Override
    public void excluirPorId(long id) {
        turma.deleteById(id);
    }

    @Override
    public Turma editar(Turma t) {
        Turma tu = this.buscarPorId(t.getId());
        tu.setDisciplina(t.getDisciplina());
        tu.setHorario(t.getHorario());
        tu.setProfessor(t.getProfessor());
        tu.setSemestre(t.getSemestre());
        return turma.save(t);
    }


}
