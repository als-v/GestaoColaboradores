package com.spring.projetopi.utils;

import com.spring.projetopi.model.Questao;
import com.spring.projetopi.repository.QuestaoRepository;

import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.repository.AlternativaRepository;

import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.repository.PerguntaRepository;

import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.repository.EmpresaRepository;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.repository.ColaboradorRepository;

import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.repository.PesquisaRepository;

import com.spring.projetopi.model.RealizacaoPesquisa;
import com.spring.projetopi.repository.RealizacaoPesquisaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class PopularRealizacaoPesquisa {
	
	@Autowired
	QuestaoRepository questaoRepository;
	
	@Autowired
	AlternativaRepository alternativaRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@Autowired
	PesquisaRepository pesquisaRepository;
	
	@Autowired
	RealizacaoPesquisaRepository realizacaoPesquisaRepository;
	
		/* 
	 * 
	 * === DESCOMENTE A LINHA ABAIXO PARA O 'SCRIPT' FUNCIONAR ===
	 * 	Apos o uso, comente novamente, se não a cada vez que o
	 * 	projeto rodar, irá adicionar os dados novamente.
	 * 
	 	*/
	
	//@PostConstruct
	public void criaPesquisa() {
		
		Empresa emp1 = new Empresa();
		emp1.setCnpj("62.843.454/0003-6");
		emp1.setEmail("aaaaa@aaaaaa.com");
		emp1.setNome("Alisson's");
		emp1.setSenha("123456");
		
		Empresa e = empresaRepository.save(emp1);
		
		Colaborador c1 = new Colaborador();
		c1.setEmail("teste@teste.com");
		c1.setNome("Teste da TEste TESTES");
		c1.setSenha("AAAASASAS");
		c1.setEmpresa(e);
		
		Colaborador cSaved = colaboradorRepository.save(c1);
		
		Pergunta p1 = new Pergunta();
		p1.setPergunta("Qual o nome do alisson?");
		
		Pergunta p = perguntaRepository.save(p1);
		
		List<Alternativa> alternativaList = new ArrayList<>();
		
		Alternativa a1 = new Alternativa();
		a1.setAlternativa(1);
		a1.setDescricao("alisson");
		a1.setCorreto(false);
		
		Alternativa a2 = new Alternativa();
		a2.setAlternativa(2);
		a2.setDescricao("primo");
		a2.setCorreto(true);
		
		Alternativa a3 = new Alternativa();
		a3.setAlternativa(3);
		a3.setDescricao("eu");
		a3.setCorreto(false);
		
		Alternativa a4 = new Alternativa();
		a4.setAlternativa(4);
		a4.setDescricao("Joao Doria");
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
		
		List<Questao> questaoList = new ArrayList<>();
		
		Questao q1 = new Questao();
		q1.setPergunta(p);
		q1.setAlternativas(alternativaList);
		
		questaoList.add(q1);
		
		for(Questao q: questaoList) {
			Questao qSaved = questaoRepository.save(q);
			System.out.println(qSaved.getQuestao_id());
		}
		
		Pesquisa pesquisa1 = new Pesquisa();
		pesquisa1.setEmpresa(e);
		pesquisa1.setQuestoes(questaoList);
		
		pesquisaRepository.save(pesquisa1);
		
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		realizacaoPesquisa.setColaborador(cSaved);
		realizacaoPesquisa.setPesquisa(pesquisa1);
		realizacaoPesquisa.setAcertos(1);
		
		realizacaoPesquisaRepository.save(realizacaoPesquisa);
	}
}
