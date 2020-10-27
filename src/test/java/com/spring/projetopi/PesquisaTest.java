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
		}else {
			empresa = empresaController.findByEmail("empresateste1@empresateste1.com");
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
	
	@Test
	public void getAllPesquisas() {
		Empresa empresa1 = new Empresa();
		
		empresa1.setNome("Empresa Teste 1");
		empresa1.setEmail("empresateste1@empresateste1.com");
		empresa1.setCnpj("00.000.000/00000-00");
		empresa1.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste1@empresateste1.com") == true) {			
			empresaController.save(empresa1);
		}else {
			empresa1 = empresaController.findByEmail("empresateste1@empresateste1.com");
		}
		
		/*====== Criação das questões ====== */
		
		/* Criação das perguntas */
		Pergunta pergunta1 = new Pergunta();
		
		pergunta1.setPergunta("Pergunta Teste 1");
		
		perguntaController.save(pergunta1);
		
		Pergunta pergunta2 = new Pergunta();
		
		pergunta2.setPergunta("Pergunta Teste 2");
		
		perguntaController.save(pergunta2);
		
		/* Criação das alternativas */
		Alternativa alternativa1 = new Alternativa();
		
		alternativa1.setAlternativa(1);
		alternativa1.setCorreto(false);
		alternativa1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa1);

		Alternativa alternativa2 = new Alternativa();
		
		alternativa2.setAlternativa(2);
		alternativa2.setCorreto(true);
		alternativa2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa2);
		
		Alternativa alternativa3 = new Alternativa();
		
		alternativa3.setAlternativa(3);
		alternativa3.setCorreto(false);
		alternativa3.setDescricao("Teste alternativa 3");
		
		alternativaController.save(alternativa3);

		Alternativa alternativa4 = new Alternativa();
		
		alternativa4.setAlternativa(4);
		alternativa4.setCorreto(false);
		alternativa4.setDescricao("Teste alternativa 4");
		
		alternativaController.save(alternativa4);	
		
		Alternativa alternativa5 = new Alternativa();
		
		alternativa5.setAlternativa(5);
		alternativa5.setCorreto(false);
		alternativa5.setDescricao("Teste alternativa 5");
		
		alternativaController.save(alternativa5);
		
		List <Alternativa> alternativas1 = new ArrayList<Alternativa>();
		
		alternativas1.add(alternativa1);
		alternativas1.add(alternativa2);
		alternativas1.add(alternativa3);
		alternativas1.add(alternativa4);
		alternativas1.add(alternativa5);
		
		Alternativa alternativa6 = new Alternativa();
		
		alternativa6.setAlternativa(1);
		alternativa6.setCorreto(false);
		alternativa6.setDescricao("Teste alternativa 6");
		
		alternativaController.save(alternativa6);

		Alternativa alternativa7 = new Alternativa();
		
		alternativa7.setAlternativa(2);
		alternativa7.setCorreto(false);
		alternativa7.setDescricao("Teste alternativa 7");
		
		alternativaController.save(alternativa7);
		
		Alternativa alternativa8 = new Alternativa();
		
		alternativa8.setAlternativa(3);
		alternativa8.setCorreto(false);
		alternativa8.setDescricao("Teste alternativa 8");
		
		alternativaController.save(alternativa8);

		Alternativa alternativa9 = new Alternativa();
		
		alternativa9.setAlternativa(4);
		alternativa9.setCorreto(true);
		alternativa9.setDescricao("Teste alternativa 9");
		
		alternativaController.save(alternativa9);	
		
		Alternativa alternativa10 = new Alternativa();
		
		alternativa10.setAlternativa(5);
		alternativa10.setCorreto(false);
		alternativa10.setDescricao("Teste alternativa 10");
		
		alternativaController.save(alternativa10);
		
		List <Alternativa> alternativas2 = new ArrayList<Alternativa>();
		
		alternativas2.add(alternativa6);
		alternativas2.add(alternativa7);
		alternativas2.add(alternativa8);
		alternativas2.add(alternativa9);
		alternativas2.add(alternativa10);
		
		/* Criação da questão */
		Questao questao1 = new Questao();
		
		questao1.setPergunta(pergunta1);
		questao1.setAlternativas(alternativas1);
		
		questaoController.save(questao1);
		
		Questao questao2 = new Questao();
		
		questao2.setPergunta(pergunta2);
		questao2.setAlternativas(alternativas2);
		
		questaoController.save(questao2);
		
		List <Questao> questoes1 = new ArrayList<Questao>();
		
		questoes1.add(questao1);
		questoes1.add(questao2);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa1 = new Pesquisa();
		
		pesquisa1.setEmpresa(empresa1);
		pesquisa1.setNome("Pesquisa Teste");
		pesquisa1.setQuestoes(questoes1);

		pesquisaController.save(pesquisa1);
		
		/* ====== Primeira criação pesquisa feita ====== */
		
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste 1");
		empresa.setEmail("empresateste2@empresateste2.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste2@empresateste2.com") == true) {			
			empresaController.save(empresa);
		}else {
			empresa = empresaController.findByEmail("empresateste2@empresateste2.com");
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
		
		/* ======== Finalização criação 2 pesquisa ======== */
		
		List<Pesquisa> pesquisas = pesquisaController.findAll();
		
		assertNotNull(pesquisas);
	}
	
	@Test
	public void findPesquisaById() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste 1");
		empresa.setEmail("empresateste1@empresateste1.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste1@empresateste1.com") == true) {			
			empresaController.save(empresa);
		}else {
			empresa = empresaController.findByEmail("empresateste1@empresateste1.com");
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
		
		Pesquisa pesquisa = pesquisaController.findById(pesquisa_1.getPesquisa_id());
		
		assertEquals(pesquisa_1.getPesquisa_id(), pesquisa.getPesquisa_id());
	}
}
