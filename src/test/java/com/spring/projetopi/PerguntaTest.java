package com.spring.projetopi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.PerguntaController;
import com.spring.projetopi.model.Pergunta;

@SpringBootTest
public class PerguntaTest {
	
	@Autowired
	PerguntaController perguntaService;
	
	@Test
	public void createPergunta() {
		Pergunta pergunta_1 = new Pergunta();
		
		pergunta_1.setPergunta("Pergunta Teste");
		
		
		assertNotNull(pergunta_1.getPergunta_id());
		assertEquals(pergunta_1.getPergunta(), "Pergunta Teste");

		//perguntaService.save(pergunta_1);
	}
}