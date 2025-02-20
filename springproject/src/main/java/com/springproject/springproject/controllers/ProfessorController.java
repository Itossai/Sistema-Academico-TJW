package com.springproject.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.springproject.entity.Professor;
import com.springproject.springproject.serviceimpl.ProfessorServiceImpl;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorServiceImpl professor;

    @GetMapping("/listar")
    String ListarProfessores(ModelMap model){
        model.addAttribute("professores", professor.buscarTodos());
        return "/professor/lista";
    }

    @GetMapping("/cadastrar")
    String CadastrarProfessor(ModelMap model){
        model.addAttribute("professor", new Professor());
        return "professor/cadastro";
    }

    @PostMapping("/salvar")
    String Salvar(Professor p){
        professor.cadastrar(p);
        return "redirect:/professores/listar";
    }

    @GetMapping("/excluir/{id}")
    String Excluir(@PathVariable("id") Long id){
        professor.excluirPorId(id);;
        return "redirect:/professores/cadastrar";
    }

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("professor",professor.buscarPorId(id));
		return "/professor/cadastro";
    }

    @PostMapping("/editar")
    String Editar(Professor p){
        professor.editar(p);
        return "redirect:/professores/listar";
    }
}
