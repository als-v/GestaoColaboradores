package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.PerguntaController;
import com.spring.projetopi.model.Pergunta;

@SpringBootTest
public class PerguntaTest {
	
	@Autowired
	PerguntaController perguntaController;
	
	@Test
	public void createPergunta() {
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste");
				
		perguntaController.save(pergunta_1);
		
		assertNotNull(pergunta_1.getPergunta_id());
		assertEquals(pergunta_1.getPergunta(), "Pergunta Teste");
	}
	
	@Test
	public void listAllPerguntas() {
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste 1");
				
		perguntaController.save(pergunta_1);
		
		Pergunta pergunta_2 = new Pergunta();
		
		pergunta_2.setPergunta("Pergunta Teste 2");
				
		perguntaController.save(pergunta_2);
		
		List<Pergunta> todasPerguntas = perguntaController.findAll();
		
		assertNotNull(todasPerguntas);
	}
	
	@Test
	public void findPerguntaById() {
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste");
				
		perguntaController.save(pergunta_1);
		
		Pergunta pergunta_2 = perguntaController.findById(pergunta_1.getPergunta_id());
		
		assertEquals(pergunta_2.getPergunta_id(), pergunta_1.getPergunta_id());
	}
}