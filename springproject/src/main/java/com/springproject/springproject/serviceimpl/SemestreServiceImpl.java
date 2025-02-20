package com.springproject.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.springproject.entity.Semestre;
import com.springproject.springproject.repository.SemestreRepository;
import com.springproject.springproject.service.SemestreService;

@Service
public class SemestreServiceImpl implements SemestreService {
    @Autowired
    private SemestreRepository semestre;

    @Override
    public List<Semestre> buscarTodos() {
        return semestre.findAll();
    }

    @Override
    public Semestre buscarPorId(Long id) {
        return semestre.findById(id).orElseThrow(()->new IllegalArgumentException("Semestre "+ id +" não encontrado! "));
    }

    @Override
    public Semestre cadastrar(Semestre s) {
        return semestre.save(s);
    }

    @Override
    public void excluirPorId(Long id) {
        semestre.deleteById(id);
    }

    @Override
    public Semestre editar(Semestre s) {
       Semestre se = this.buscarPorId(s.getId());
       se.setAno(s.getAno());
       se.setDataFim(s.getDataFim());
       se.setDataInicio(s.getDataInicio());
       se.setPeriodo(s.getPeriodo());
       return semestre.save(se);
    }

}
