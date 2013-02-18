package com.serpro.depae.treinamento.webescola.domain;

import java.util.ArrayList;
import java.util.List;


public class TurmaFactory {
	
	public static List<Turma> createBean() {
		Turma turma = new Turma("101");
		Aluno aluno1 = new Aluno("Eduardo Lopes");
		aluno1.setCpf("12223");
		
		Aluno aluno2 = new Aluno("Diógenes Fabris");
		aluno2.setCpf("12223");

		Aluno aluno3 = new Aluno("Hélio Miranda");
		aluno3.setCpf("12223");

		Aluno aluno4 = new Aluno("Jô Soares");
		aluno4.setCpf("12223");

		
		turma.getAlunos().add(aluno1);
		turma.getAlunos().add(aluno2);
		turma.getAlunos().add(aluno3);
		turma.getAlunos().add(aluno4);
		
		Turma turma2 = new Turma("201");

		turma2.getAlunos().add(aluno1);
		turma2.getAlunos().add(aluno2);
		turma2.getAlunos().add(aluno3);
		turma2.getAlunos().add(aluno4);

		
		List<Turma> list = new ArrayList<Turma>();
		list.add(turma);
		list.add(turma2);
		return list;
	}
	
	
}
