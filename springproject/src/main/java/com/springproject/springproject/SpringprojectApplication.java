package com.springproject.springproject;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springproject.springproject.entity.Aluno;
import com.springproject.springproject.repository.AlunoCustomRepository;
import com.springproject.springproject.repository.AlunoRepository;


@SpringBootApplication
public class SpringprojectApplication {//implements CommandLineRunner 
/* 	@Autowired
	private AlunoRepository aluno;
	@Autowired
	private AlunoCustomRepository alunocustom; */
	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

	/* @Override
	public void run(String... args) throws Exception{
		Aluno a = new Aluno();
		a.setNome("Nymeria");
		a.setDtNascimento(new Date());
		a.setEmail("namoursoir@outlook.com");
		a.setMatricula("aa-2024.2-11004456");
		aluno.save(a);

		List<Aluno> listaluno = alunocustom.findAllCustomAlunos(null, null, null);
		
		for (Iterator iterator = listaluno.iterator() ; iterator.hasNext(); ){
			Aluno ai = (Aluno) iterator.next();
			System.out.println("Aluno id: "+ai.getId()+ " nome: "+ai.getNome()+" data de nasciumento: "+
			ai.getDtNascimento()+" email: "+ai.getEmail()+ " matricula: "+ai.getEmail());

		} 
	} */
}
