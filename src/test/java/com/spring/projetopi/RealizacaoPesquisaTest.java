package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.AlternativaController;
import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.controller.PerguntaController;
import com.spring.projetopi.controller.PesquisaController;
import com.spring.projetopi.controller.QuestaoController;
import com.spring.projetopi.controller.RealizacaoPesquisaController;
import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.Questao;
import com.spring.projetopi.model.RealizacaoPesquisa;

@SpringBootTest
public class RealizacaoPesquisaTest {
	
	@Autowired
	RealizacaoPesquisaController realizacaoPesquisaController;
	
	@Autowired
	EmpresaController empresaController;
	
	@Autowired
	ColaboradorController colaboradorController;
	
	@Autowired
	PerguntaController perguntaController;
	
	@Autowired
	QuestaoController questaoController;
	
	@Autowired
	PesquisaController pesquisaController;
	
	@Autowired
	AlternativaController alternativaController;
	
	@Test
	public void createRealizacaoPesquisa() {
		/* ==== COLABORADOR ==== */
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("email@email.com") == true) {
			empresaController.save(empresa);			
		}else {
			empresa = empresaController.findByEmail("email@email.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("teste@teste.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("teste@teste.com");
		}
		
		/* ==== PESQUISA ==== */
		
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste 1");
		
		perguntaController.save(pergunta_1);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(true);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(false);
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
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas_1);
		
		questaoController.save(questao_1);
		
		List <Questao> questoes = new ArrayList<Questao>();
		
		questoes.add(questao_1);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa_1 = new Pesquisa();
		
		pesquisa_1.setEmpresa(empresa);
		pesquisa_1.setNome("Pesquisa Teste");
		pesquisa_1.setQuestoes(questoes);
		
		pesquisaController.save(pesquisa_1);
		
		/* ==== REALIZAÇÃO - PESQUISA ==== */
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa_1);
		
		List<Boolean> a = new ArrayList<Boolean>();
		
		a.add(false);
		a.add(true);
		a.add(true);
		a.add(true);
		a.add(true);
		
		List<Integer> acertos = realizacaoPesquisaController.calcAcertos(pesquisa_1, a);
		
		realizacaoPesquisa.setAcertos(acertos.get(0));
		realizacaoPesquisa.setErros(acertos.get(1));
		
		realizacaoPesquisa.setPorcentagemAcerto(realizacaoPesquisaController.calcPorcentagemAcertos(acertos.get(0), realizacaoPesquisa.getPesquisa().getQuestoes().size() * 5));
		realizacaoPesquisa.setPorcentagemErro(realizacaoPesquisaController.calcPorcentagemErro(realizacaoPesquisa.getPorcentagemAcerto()));
		
		realizacaoPesquisaController.save(realizacaoPesquisa);

		assertEquals(realizacaoPesquisa.getColaborador().getNome(), colaborador.getNome());
		assertEquals(realizacaoPesquisa.getPesquisa().getNome(), pesquisa_1.getNome());
		assertEquals(realizacaoPesquisa.getAcertos(), 0);
		assertEquals(realizacaoPesquisa.getErros(), 5);
		assertEquals(realizacaoPesquisa.getPorcentagemAcerto(), 0);
		assertEquals(realizacaoPesquisa.getPorcentagemErro(), 100);
	}
	
	@Test
	public void listAllRealizacaoPesquisa() {
		/* ==== COLABORADOR ==== */
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("email@email.com") == true) {
			empresaController.save(empresa);			
		}else {
			empresa = empresaController.findByEmail("email@email.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("teste@teste.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("teste@teste.com");
		}
		
		/* ==== PESQUISA ==== */
		
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
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas_1);
		
		questaoController.save(questao_1);
		
		//Questao questao_2 = new Questao();
		
		//questao_2.setPergunta(pergunta_2);
		//questao_2.setAlternativas(alternativas_2);
		
		//questaoController.save(questao_2);
		
		List <Questao> questoes = new ArrayList<Questao>();
		
		questoes.add(questao_1);
		//questoes.add(questao_2);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa_1 = new Pesquisa();
		
		pesquisa_1.setEmpresa(empresa);
		pesquisa_1.setNome("Pesquisa Teste");
		pesquisa_1.setQuestoes(questoes);
		
		pesquisaController.save(pesquisa_1);
		
		/* ==== REALIZAÇÃO - PESQUISA ==== */
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa_1);
		
		List<Boolean> a = new ArrayList<Boolean>();
		
		a.add(false);
		a.add(false);
		a.add(true);
		a.add(false);
		a.add(true);
		
		List<Integer> acertos = realizacaoPesquisaController.calcAcertos(pesquisa_1, a);
		
		realizacaoPesquisa.setAcertos(acertos.get(0));
		realizacaoPesquisa.setErros(acertos.get(1));
		
		realizacaoPesquisa.setPorcentagemAcerto(realizacaoPesquisaController.calcPorcentagemAcertos(acertos.get(0), realizacaoPesquisa.getPesquisa().getQuestoes().size() * 5));
		realizacaoPesquisa.setPorcentagemErro(realizacaoPesquisaController.calcPorcentagemErro(realizacaoPesquisa.getPorcentagemAcerto()));
		
		realizacaoPesquisaController.save(realizacaoPesquisa);

		List<RealizacaoPesquisa> realizacaoAll = realizacaoPesquisaController.findAll();
		
		assertNotNull(realizacaoAll);
	}
	
	@Test
	public void findRealizacaoPesquisaById() {
		/* ==== COLABORADOR ==== */
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("email@email.com") == true) {
			empresaController.save(empresa);			
		}else {
			empresa = empresaController.findByEmail("email@email.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("teste@teste.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("teste@teste.com");
		}
		
		/* ==== PESQUISA ==== */
		
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
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas_1);
		
		questaoController.save(questao_1);
		
		//Questao questao_2 = new Questao();
		
		//questao_2.setPergunta(pergunta_2);
		//questao_2.setAlternativas(alternativas_2);
		
		//questaoController.save(questao_2);
		
		List <Questao> questoes = new ArrayList<Questao>();
		
		questoes.add(questao_1);
		//questoes.add(questao_2);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa_1 = new Pesquisa();
		
		pesquisa_1.setEmpresa(empresa);
		pesquisa_1.setNome("Pesquisa Teste");
		pesquisa_1.setQuestoes(questoes);
		
		pesquisaController.save(pesquisa_1);
		
		/* ==== REALIZAÇÃO - PESQUISA ==== */
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa_1);
		
		List<Boolean> a = new ArrayList<Boolean>();
		
		a.add(false);
		a.add(false);
		a.add(true);
		a.add(false);
		a.add(true);
		
		List<Integer> acertos = realizacaoPesquisaController.calcAcertos(pesquisa_1, a);
		
		realizacaoPesquisa.setAcertos(acertos.get(0));
		realizacaoPesquisa.setErros(acertos.get(1));
		
		realizacaoPesquisa.setPorcentagemAcerto(realizacaoPesquisaController.calcPorcentagemAcertos(acertos.get(0), realizacaoPesquisa.getPesquisa().getQuestoes().size() * 5));
		realizacaoPesquisa.setPorcentagemErro(realizacaoPesquisaController.calcPorcentagemErro(realizacaoPesquisa.getPorcentagemAcerto()));
		realizacaoPesquisaController.save(realizacaoPesquisa);
		
		RealizacaoPesquisa p = realizacaoPesquisaController.findById(realizacaoPesquisa.getRealizacaopesquisa_id());
		
		assertEquals(p.getRealizacaopesquisa_id(), realizacaoPesquisa.getRealizacaopesquisa_id());
	
	}
	
	@Test
	public void findRealizacaoPesquisaByColab() {
		/* ==== COLABORADOR ==== */
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("email@email.com") == true) {
			empresaController.save(empresa);			
		}else {
			empresa = empresaController.findByEmail("email@email.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("teste@teste.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("teste@teste.com");
		}
		
		/* ==== PESQUISA ==== */
		
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste 1");
		
		perguntaController.save(pergunta_1);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(true);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(false);
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
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas_1);
		
		questaoController.save(questao_1);
		
		List <Questao> questoes = new ArrayList<Questao>();
		
		questoes.add(questao_1);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa_1 = new Pesquisa();
		
		pesquisa_1.setEmpresa(empresa);
		pesquisa_1.setNome("Pesquisa Teste");
		pesquisa_1.setQuestoes(questoes);
		
		pesquisaController.save(pesquisa_1);
		
		/* ==== REALIZAÇÃO - PESQUISA ==== */
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa_1);
		
		List<Boolean> a = new ArrayList<Boolean>();
		
		a.add(false);
		a.add(true);
		a.add(true);
		a.add(true);
		a.add(true);
		
		List<Integer> acertos = realizacaoPesquisaController.calcAcertos(pesquisa_1, a);
		
		realizacaoPesquisa.setAcertos(acertos.get(0));
		realizacaoPesquisa.setErros(acertos.get(1));
		
		realizacaoPesquisa.setPorcentagemAcerto(realizacaoPesquisaController.calcPorcentagemAcertos(acertos.get(0), realizacaoPesquisa.getPesquisa().getQuestoes().size() * 5));
		realizacaoPesquisa.setPorcentagemErro(realizacaoPesquisaController.calcPorcentagemErro(realizacaoPesquisa.getPorcentagemAcerto()));
		
		realizacaoPesquisaController.save(realizacaoPesquisa);
		
		List<RealizacaoPesquisa> pesquisas = realizacaoPesquisaController.findByColaborador(colaborador);
		
		assertEquals(pesquisas.get(0).getColaborador().getColaborador_id(), colaborador.getColaborador_id());
	}
	
	@Test
	public void resultPesquisas() {
		/* ==== COLABORADOR ==== */
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("email@email.com") == true) {
			empresaController.save(empresa);			
		}else {
			empresa = empresaController.findByEmail("email@email.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("teste@teste.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("teste@teste.com");
		}
		
		/* ==== PESQUISA ==== */
		
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste 1");
		
		perguntaController.save(pergunta_1);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(true);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(false);
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
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas_1);
		
		questaoController.save(questao_1);
		
		List <Questao> questoes = new ArrayList<Questao>();
		
		questoes.add(questao_1);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa_1 = new Pesquisa();
		
		pesquisa_1.setEmpresa(empresa);
		pesquisa_1.setNome("Pesquisa Teste");
		pesquisa_1.setQuestoes(questoes);
		
		pesquisaController.save(pesquisa_1);
		
		/* ==== REALIZAÇÃO - PESQUISA ==== */
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa_1);
		
		List<Boolean> a = new ArrayList<Boolean>();
		
		a.add(true);
		a.add(false);
		a.add(false);
		a.add(false);
		a.add(false);
		
		List<Integer> acertos = realizacaoPesquisaController.calcAcertos(pesquisa_1, a);
		
		realizacaoPesquisa.setAcertos(acertos.get(0));
		realizacaoPesquisa.setErros(acertos.get(1));
		
		realizacaoPesquisa.setPorcentagemAcerto(realizacaoPesquisaController.calcPorcentagemAcertos(acertos.get(0), realizacaoPesquisa.getPesquisa().getQuestoes().size() * 5));
		realizacaoPesquisa.setPorcentagemErro(realizacaoPesquisaController.calcPorcentagemErro(realizacaoPesquisa.getPorcentagemAcerto()));
		
		realizacaoPesquisaController.save(realizacaoPesquisa);
		
		List<Pesquisa> pesquisas = realizacaoPesquisaController.calcResultados();
		
		for(int i = 0; i < pesquisas.size(); i++) {
			if(pesquisas.get(i).getPesquisa_id() == pesquisa_1.getPesquisa_id()) {
				assertEquals(pesquisas.get(i).getAcertoGeral(), 100);
			}
		}
		
	}
	
	@Test
	public void findPesquisaEmpresa() {
		/* ==== COLABORADOR ==== */
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("email@email.com") == true) {
			empresaController.save(empresa);			
		}else {
			empresa = empresaController.findByEmail("email@email.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("teste@teste.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("teste@teste.com");
		}
		
		/* ==== PESQUISA ==== */
		
		/* Criação das perguntas */
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste 1");
		
		perguntaController.save(pergunta_1);
		
		/* Criação das alternativas */
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(true);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(false);
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
		
		/* Criação da questão */
		Questao questao_1 = new Questao();
		
		questao_1.setPergunta(pergunta_1);
		questao_1.setAlternativas(alternativas_1);
		
		questaoController.save(questao_1);
		
		List <Questao> questoes = new ArrayList<Questao>();
		
		questoes.add(questao_1);
		
		/*====== FIM ====== */
		
		// Criação de pesquisa
		
		Pesquisa pesquisa_1 = new Pesquisa();
		
		pesquisa_1.setEmpresa(empresa);
		pesquisa_1.setNome("Pesquisa Teste");
		pesquisa_1.setQuestoes(questoes);
		
		pesquisaController.save(pesquisa_1);
		
		/* ==== REALIZAÇÃO - PESQUISA ==== */
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa_1);
		
		List<Boolean> a = new ArrayList<Boolean>();
		
		a.add(true);
		a.add(false);
		a.add(false);
		a.add(false);
		a.add(false);
		
		List<Integer> acertos = realizacaoPesquisaController.calcAcertos(pesquisa_1, a);
		
		realizacaoPesquisa.setAcertos(acertos.get(0));
		realizacaoPesquisa.setErros(acertos.get(1));
		
		realizacaoPesquisa.setPorcentagemAcerto(realizacaoPesquisaController.calcPorcentagemAcertos(acertos.get(0), realizacaoPesquisa.getPesquisa().getQuestoes().size() * 5));
		realizacaoPesquisa.setPorcentagemErro(realizacaoPesquisaController.calcPorcentagemErro(realizacaoPesquisa.getPorcentagemAcerto()));
		
		realizacaoPesquisaController.save(realizacaoPesquisa);
		
		List<RealizacaoPesquisa> pesquisasEmp = realizacaoPesquisaController.findByEmpresa(empresa);	
		
		assertEquals(pesquisasEmp.get(0).getPesquisa().getEmpresa().getEmpresa_id(), empresa.getEmpresa_id());
		
	}
	
}
