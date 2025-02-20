package com.springproject.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.springproject.entity.Turma;
import com.springproject.springproject.serviceimpl.DisciplinaServiceImpl;
import com.springproject.springproject.serviceimpl.ProfessorServiceImpl;
import com.springproject.springproject.serviceimpl.SemestreServiceImpl;
import com.springproject.springproject.serviceimpl.TurmaServiceImpl;


@Controller
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private SemestreServiceImpl semestre;

    @Autowired
    private TurmaServiceImpl turma;
    
    @Autowired
    private DisciplinaServiceImpl disciplina;
    
    @Autowired
    private ProfessorServiceImpl professor;

    @GetMapping("/listar")
    public String listarTurmas(ModelMap model) {
        model.addAttribute("turmas", turma.listarTodas());
        return "turma/lista";
    }

    @GetMapping("/cadastrar")
    public String cadastrarTurma(ModelMap model) {
        model.addAttribute("turma", new Turma());
        model.addAttribute("disciplinas", disciplina.buscarTodos());
        model.addAttribute("professores", professor.buscarTodos());
        model.addAttribute("semestres", semestre.buscarTodos());
        return "turma/cadastro";
    }

    @PostMapping("/salvar")
    public String salvarTurma(Turma t) {
        turma.cadastrar(t);
        return "redirect:/turmas/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarTurma(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("turma", turma.buscarPorId(id));
        model.addAttribute("disciplinas", disciplina.buscarTodos());
        model.addAttribute("professores", professor.buscarTodos());
        model.addAttribute("semestres", semestre.buscarTodos());
        return "turmas/cadastro";
    }

    @GetMapping("/excluir/{id}")
    public String excluirTurma(@PathVariable("id") Long id) {
        turma.excluirPorId(id);
        return "redirect:/turmas/cadastrar";
    }

    @PostMapping("/editar")
    String Editar(Turma t){
        turma.editar(t);
        return "redirect:/turmas/listar";
    }

   
}
