package com.springproject.springproject.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id")
    private Turma turma;
    
    private LocalDate dataMatricula;

    // Construtor padrão
    public Matricula() {
        this.dataMatricula = LocalDate.now();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
