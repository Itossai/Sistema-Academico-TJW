package com.springproject.springproject.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springproject.springproject.entity.Aluno;

import jakarta.persistence.EntityManager;

@Repository
public class AlunoCustomRepository {

    private EntityManager em;

    public AlunoCustomRepository(EntityManager em){
        super();
        this.em = em;
    }

    public List<Aluno> findAllCustomAlunos(Long id, String nome, String email){
        String query = "select a from Aluno a ";
        String condicao = "where";

        if (id != null){
            query+=condicao+"a.id = :id";
            condicao+= " and ";
        }
        if (nome != null){
            query+=condicao+"a.nome = :nome";
            condicao+= " and ";
        }
        if (email != null){
            query+=condicao+"a.email = :email";
        }

        var q = em.createQuery(query,Aluno.class);

        if (id != null){
            q.setParameter("id",id);
        }
        if (nome !=null){
            q.setParameter("nome",nome);
        }
        if (email != null){
            q.setParameter("email", email);
        }

        return q.getResultList();
    }
}
