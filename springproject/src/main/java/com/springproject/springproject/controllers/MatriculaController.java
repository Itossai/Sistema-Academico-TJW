package com.springproject.springproject.controllers;

import com.springproject.springproject.entity.Matricula;
import com.springproject.springproject.serviceimpl.MatriculaServiceImpl;
import com.springproject.springproject.serviceimpl.AlunoServiceImpl;
import com.springproject.springproject.serviceimpl.TurmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl matriculaService;
    
    @Autowired
    private AlunoServiceImpl alunoService;
    
    @Autowired
    private TurmaServiceImpl turmaService;
    
    @GetMapping("/listar")
    public String listarMatriculas(ModelMap model) {
        model.addAttribute("matriculas", matriculaService.buscarTodos());
        return "matricula/lista";
    }
    
    @GetMapping("/cadastrar")
    public String formularioCadastrarMatricula(ModelMap model) {
        model.addAttribute("matricula", new Matricula());
        model.addAttribute("alunos", alunoService.buscarTodos());
        model.addAttribute("turmas", turmaService.listarTodas());
        return "matricula/cadastro";
    }
    
    @PostMapping("/salvar")
    public String salvarMatricula(Matricula m) {
        matriculaService.cadastrar(m);
        return "redirect:/matriculas/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editarMatricula(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("matricula", matriculaService.buscarPorId(id));
        model.addAttribute("alunos", alunoService.buscarTodos());
        model.addAttribute("turmas", turmaService.listarTodas());
        return "matricula/cadastro";
    }
    
    @PostMapping("/editar")
    public String atualizarMatricula(Matricula m) {
        matriculaService.editar(m);
        return "redirect:/matriculas/listar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirMatricula(@PathVariable("id") Long id) {
        matriculaService.excluirPorId(id);
        return "redirect:/matriculas/listar";
    }

    @GetMapping("/alunosmatriculados")
    public String relatorioMatriculas(ModelMap model) {
        // Certifique-se de que a consulta retorne as turmas com as matrículas (possivelmente usando JOIN FETCH)
        model.addAttribute("matriculas", matriculaService.buscarTodos());
        return "matricula/aluno";
    }
}
