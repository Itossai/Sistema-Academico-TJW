package com.springproject.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springproject.springproject.entity.Disciplina;
import com.springproject.springproject.serviceimpl.DisciplinaServiceImpl;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaServiceImpl disciplina;

    @GetMapping("/listar")
    String ListarDisciplinas(ModelMap model){
        model.addAttribute("disciplinas", disciplina.buscarTodos());
        return "/disciplina/lista";
    }

    @GetMapping("cadastrar")
    String CadastrarDisciplina(ModelMap model){
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/cadastro";
    }

    @PostMapping("/salvar")
    String Salvar(Disciplina d){
        disciplina.cadastrar(d);
        return "redirect:/disciplinas/listar";
    }

    @GetMapping("/excluir/{id}")
    String Excluir(@PathVariable("id") Long id){
        disciplina.excluirPorId(id);;
        return "redirect:/disciplinas/cadastrar";
    }

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("disciplina",disciplina.buscarPorId(id));
		return "/disciplina/cadastro";
    }

    @PostMapping("/editar")
    String Editar(Disciplina d){
        disciplina.editar(d);
        return "redirect:/disciplinas/listar";
    }
}
