package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
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
		
		
		assertNotNull(pergunta_1.getPergunta_id());
		assertEquals(pergunta_1.getPergunta(), "Pergunta Teste");

		//perguntaController.save(pergunta_1);
	}
}