package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.AlternativaController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.controller.PerguntaController;
import com.spring.projetopi.controller.PesquisaController;
import com.spring.projetopi.controller.QuestaoController;
import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.Questao;

@SpringBootTest
public class PesquisaTest {
	
	@Autowired
	PesquisaController pesquisaController;
	
	@Autowired
	EmpresaController empresaController;
	
	@Autowired
	PerguntaController perguntaController;
	
	@Autowired
	AlternativaController alternativaController;
	
	@Autowired
	QuestaoController questaoController;
	
	@Test
	public void createTest() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste 1");
		empresa.setEmail("empresateste1@empresateste1.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste1@empresateste1.com") == true) {			
			empresaController.save(empresa);
		}
		
		/*====== Criação das questões ====== */
		
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste 1");
		
		perguntaController.save(pergunta_1);
		
		Pergunta pergunta_2 = new Pergunta();
		
		pergunta_2.setPergunta("Pergunta Teste 2");
		
		perguntaController.save(pergunta_2);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(false);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(true);
		alternativa_2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa_2);
		
		Alternativa alternativa_3 = new Alternativa();
		
		alternativa_3.setAlternativa(3);
		alternativa_3.setCorreto(false);
		alternativa_3.setDescricao("Teste alternativa 3");
		
		alternativaController.save(alternativa_3);

		Alternativa alternativa_4 = new Alternativa();
		
		alternativa_4.setAlternativa(4);
		alternativa_4.setCorreto(false);
		alternativa_4.setDescricao("Teste alternativa 4");
		
		alternativaController.save(alternativa_4);	
		
		Alternativa alternativa_5 = new Alternativa();
		
		alternativa_5.setAlternativa(5);
		alternativa_5.setCorreto(false);
		alternativa_5.setDescricao("Teste alternativa 5");
		
		alternativaController.save(alternativa_5);
		
		List <Alternativa> alternativas_1 = new ArrayList<Alternativa>();
		
		alternativas_1.add(alternativa_1);
		alternativas_1.add(alternativa_2);
		alternativas_1.add(alternativa_3);
		alternativas_1.add(alternativa_4);
		alternativas_1.add(alternativa_5);
		
		Alternativa alternativa_6 = new Alternativa();
		
		alternativa_6.setAlternativa(1);
		alternativa_6.setCorreto(false);
		alternativa_6.setDescricao("Teste alternativa 6");
		
		alternativaController.save(alternativa_6);

		Alternativa alternativa_7 = new Alternativa();
		
		alternativa_7.setAlternativa(2);
		alternativa_7.setCorreto(false);
		alternativa_7.setDescricao("Teste alternativa 7");
		
		alternativaController.save(alternativa_7);
		
		Alternativa alternativa_8 = new Alternativa();
		
		alternativa_8.setAlternativa(3);
		alternativa_8.setCorreto(false);
		alternativa_8.setDescricao("Teste alternativa 8");
		
		alternativaController.save(alternativa_8);

		Alternativa alternativa_9 = new Alternativa();
		
		alternativa_9.setAlternativa(4);
		alternativa_9.setCorreto(true);
		alternativa_9.setDescricao("Teste alternativa 9");
		
		alternativaController.save(alternativa_9);	
		
		Alternativa alternativa_10 = new Alternativa();
		
		alternativa_10.setAlternativa(5);
		alternativa_10.setCorreto(false);
		alternativa_10.setDescricao("Teste alternativa 10");
		
		alternativaController.save(alternativa_10);
		
		List <Alternativa> alternativas_2 = new ArrayList<Alternativa>();
		
		alternativas_2.add(alternativa_6);
		alternativas_2.add(alternativa_7);
		alternativas_2.add(alternativa_8);
		alternativas_2.add(alternativa_9);
		alternativas_2.add(alternativa_10);
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas_1);
		
		questaoController.save(questao_1);
		
		Questao questao_2 = new Questao();
		
		questao_2.setPergunta(pergunta_2);
		questao_2.setAlternativas(alternativas_2);
		
		questaoController.save(questao_2);
		
		List <Questao> questoes = new ArrayList<Questao>();
		
		questoes.add(questao_1);
		questoes.add(questao_2);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa_1 = new Pesquisa();
		
		pesquisa_1.setEmpresa(empresa);
		pesquisa_1.setNome("Pesquisa Teste");
		pesquisa_1.setQuestoes(questoes);

		pesquisaController.save(pesquisa_1);
		
		assertNotNull(pesquisa_1.getPesquisa_id());
		assertEquals(pesquisa_1.getNome(), "Pesquisa Teste");
		assertEquals(pesquisa_1.getEmpresa().getNome(), empresa.getNome());
		
		for(int i = 0; i < pesquisa_1.getQuestoes().size(); i++) {
			if(i == 0) {
				assertEquals(pesquisa_1.getQuestoes().get(i).getPergunta().getPergunta(), questao_1.getPergunta().getPergunta());
			}
			if(i == 2) {
				assertEquals(pesquisa_1.getQuestoes().get(i).getPergunta().getPergunta(), questao_2.getPergunta().getPergunta());
			}
		}
		
	}
}
