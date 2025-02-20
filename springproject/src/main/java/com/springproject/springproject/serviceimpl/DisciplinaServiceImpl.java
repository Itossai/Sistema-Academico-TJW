package com.springproject.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.entity.Disciplina;
import com.springproject.springproject.repository.DisciplinaRepository;
import com.springproject.springproject.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {
    @Autowired
    DisciplinaRepository disciplina;

    @Override
    public List<Disciplina> buscarTodos() {
        return disciplina.findAll();
       
    }

    @Override
    public Disciplina buscarPorId(Long id) {
        return disciplina.findById(id).orElseThrow(() -> new IllegalArgumentException("Disciplina "+ id +" não encontrado! "));
    }

    @Override
    public Disciplina cadastrar(Disciplina d) {
        return disciplina.save(d);
    }

    @Override
    public void excluirPorId(Long id) {
        disciplina.deleteById(id);
    }

    @Override
    public Disciplina editar(Disciplina d) {
        Disciplina di = this.buscarPorId(d.getId());
        di.setNome(d.getNome());
        di.setEmenta(d.getEmenta());
        di.setCargaHoraria(d.getCargaHoraria());
        di.setCodigo(d.getCodigo());
        return disciplina.save(di);
    }

    @Override
    public Disciplina buscarPorCodigo(String codigo) {
        return disciplina.findByCodigo(codigo).orElseThrow(()->new IllegalArgumentException("Disciplina de: "+ codigo +" não encontrado! "));
    }

}
