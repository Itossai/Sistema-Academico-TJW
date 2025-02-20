package com.springproject.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.entity.Matricula;
import com.springproject.springproject.repository.MatriculaRepository;
import com.springproject.springproject.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService{
    @Autowired
    private MatriculaRepository matricula;

    @Override
    public List<Matricula> buscarTodos() {
        return matricula.findAll();
    }

    @Override
    public Matricula buscarPorId(Long id) {
        return matricula.findById(id).orElseThrow(()-> new IllegalArgumentException("Matricula "+ id +" não encontrada! "));
    }

    @Override
    public Matricula cadastrar(Matricula m) {
        return matricula.save(m);
    }

    @Override
    public void excluirPorId(Long id) {
        matricula.deleteById(id);;
    }

    @Override
    public Matricula editar(Matricula m) {
        Matricula ma = this.buscarPorId(m.getId());
        ma.setAluno(m.getAluno());
        ma.setDataMatricula(m.getDataMatricula());
        ma.setTurma(m.getTurma());
        return matricula.save(ma);
    }

    

}
