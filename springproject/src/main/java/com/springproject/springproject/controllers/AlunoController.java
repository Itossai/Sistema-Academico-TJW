package com.springproject.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.springproject.entity.Aluno;
import com.springproject.springproject.serviceimpl.AlunoServiceImpl;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl aluno;

    @GetMapping("/listar")
    String ListarAlunos(ModelMap model){
        model.addAttribute("alunos", aluno.buscarTodos());
        return "/aluno/lista";
    }

    @GetMapping("cadastrar")
    String CadastrarAlunos(ModelMap model){
        model.addAttribute("aluno", new Aluno());
        return "aluno/cadastro";
    }

    @PostMapping("/salvar")
    String Salvar(@Validated @ModelAttribute("aluno") Aluno a,
                BindingResult bindingResult){

                    
                    if (bindingResult.hasErrors()) {
                        return "aluno/cadastro"; // Certifique-se de usar o caminho correto
                    }
                    
                    // Verifica se o CPF já está cadastrado
                    if (a.getCpf() != null && !a.getCpf().trim().isEmpty() && aluno.buscarPorCPF(a.getCpf()) != null) {
                        bindingResult.rejectValue("cpf", "error.aluno", "CPF já cadastrado");
                        return "aluno/cadastro"; // Use o mesmo nome de view usado no GET
                    }
        
        aluno.cadastrar(a);
        return "redirect:/alunos/listar";
    }
    
    @GetMapping("/excluir/{id}")
    String Excluir(@PathVariable("id") Long id){
        aluno.excluirPorId(id);;
        return "redirect:/alunos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("aluno",aluno.buscarPorId(id));
		return "/aluno/cadastro";
    }

    @PostMapping("/editar")
    String Editar(Aluno a){
        aluno.editar(a);
        return "redirect:/alunos/listar";
    }
}
