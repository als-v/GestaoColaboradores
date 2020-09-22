package com.spring.projetopi.utils;

import com.spring.projetopi.model.Questao;
import com.spring.projetopi.repository.QuestaoRepository;

import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.repository.AlternativaRepository;

import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.repository.PerguntaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class PopularQuestao {
	
	@Autowired
	QuestaoRepository questaoRepository;
	
	@Autowired
	AlternativaRepository alternativaRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
		/* 
	 * 
	 * === DESCOMENTE A LINHA ABAIXO PARA O 'SCRIPT' FUNCIONAR ===
	 * 	Apos o uso, comente novamente, se não a cada vez que o
	 * 	projeto rodar, irá adicionar os dados novamente.
	 * 
	 	*/
	
	//@PostConstruct
	public void criaQuestao() {
		
		Pergunta p1 = new Pergunta();
		p1.setPergunta("Qem descobriu o brasil?");
		
		Pergunta p = perguntaRepository.save(p1);
		
		List<Alternativa> alternativaList = new ArrayList<>();
		
		Alternativa a1 = new Alternativa();
		a1.setAlternativa(1);
		a1.setDescricao("Pedro Alvares Toledo");
		a1.setCorreto(false);
		
		Alternativa a2 = new Alternativa();
		a2.setAlternativa(2);
		a2.setDescricao("Jose paulo Freire");
		a2.setCorreto(true);
		
		Alternativa a3 = new Alternativa();
		a3.setAlternativa(3);
		a3.setDescricao("Maria Lurdes");
		a3.setCorreto(false);
		
		Alternativa a4 = new Alternativa();
		a4.setAlternativa(4);
		a4.setDescricao("Lucas Dolores");
		a4.setCorreto(false);
		
		Alternativa a5 = new Alternativa();
		a5.setAlternativa(5);
		a5.setDescricao("Loren Ipysun");
		a5.setCorreto(false);
		
		alternativaList.add(a1);
		alternativaList.add(a2);
		alternativaList.add(a3);
		alternativaList.add(a4);
		alternativaList.add(a5);
		
		for(Alternativa a: alternativaList) {
			Alternativa aSaved = alternativaRepository.save(a);
			System.out.println(aSaved.getAlternativa_id());
		}
		
		Questao q1 = new Questao();
		q1.setPergunta(p);
		q1.setAlternativas(alternativaList);
		
		Questao q = questaoRepository.save(q1);
		
		/*
		Alternativa a1 = new Alternativa();
		a1.setAlternativa(1);
		a1.setDescricao("Pedro Alvares Toledo");
		a1.setCorreto(false);
		
		Alternativa a2 = new Alternativa();
		a2.setAlternativa(2);
		a2.setDescricao("Jose paulo Freire");
		a2.setCorreto(true);
		
		Alternativa a3 = alternativaRepository.save(a1);
		Alternativa a4 = alternativaRepository.save(a2);
		
		System.out.println(a3.getAlternativa_id());
		System.out.println(a4.getAlternativa_id());
		*/
	}
}
