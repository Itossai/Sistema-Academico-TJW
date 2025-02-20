package com.springproject.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.springproject.entity.Semestre;
import com.springproject.springproject.serviceimpl.SemestreServiceImpl;

@Controller
@RequestMapping("/semestres")
public class SemestreController {

    @Autowired
    private SemestreServiceImpl semestre;

    @GetMapping("/listar")
    String listarSemestres(ModelMap model){
        model.addAttribute("semestres", semestre.buscarTodos());
        return "/semestre/lista";
    }

    @GetMapping("/cadastrar")
    String cadastrarSemestre(ModelMap model){
        model.addAttribute("semestre", new Semestre());
        return "semestre/cadastro";
    }

    @PostMapping("/salvar")
    String salvar(Semestre s){
        semestre.cadastrar(s);
        return "redirect:/semestres/listar";
    }

    @GetMapping("/excluir/{id}")
    String excluir(@PathVariable("id") Long id){
        semestre.excluirPorId(id);
        return "redirect:/semestres/cadastrar";
    }

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("disciplina",semestre.buscarPorId(id));
		return "/semestre/cadastro";
    }

    @PostMapping("/editar")
    String editar(Semestre s){
        semestre.editar(s);
        return "redirect:/semestres/listar";
    }
}
