package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.AlternativaController;
import com.spring.projetopi.model.Alternativa;

@SpringBootTest
public class AlternativaTests {
	
	@Autowired
	AlternativaController alternativaController;
	
	@Test
	public void createAlternativa() {
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(false);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		assertNotNull(alternativa_1.getAlternativa_id());
		assertFalse(alternativa_1.isCorreto());
		assertEquals(alternativa_1.getAlternativa(), 1);
		assertEquals(alternativa_1.getDescricao(), "Teste alternativa 1");
		

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(true);
		alternativa_2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa_2);

		assertNotNull(alternativa_2.getAlternativa_id());
		assertTrue(alternativa_2.isCorreto());
		assertEquals(alternativa_2.getAlternativa(), 2);
		assertEquals(alternativa_2.getDescricao(), "Teste alternativa 2");
	}
	
	@Test
	public void findAlternativaById() {
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(false);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa = alternativaController.findById(alternativa_1.getAlternativa_id());
		
		assertEquals(alternativa.getAlternativa_id(), alternativa_1.getAlternativa_id());
	}
	
	@Test
	public void findAllAlternativas() {
		Alternativa alternativa_1 = new Alternativa();
		
		alternativa_1.setAlternativa(1);
		alternativa_1.setCorreto(false);
		alternativa_1.setDescricao("Teste alternativa 1");
		
		alternativaController.save(alternativa_1);

		Alternativa alternativa_2 = new Alternativa();
		
		alternativa_2.setAlternativa(2);
		alternativa_2.setCorreto(false);
		alternativa_2.setDescricao("Teste alternativa 2");
		
		alternativaController.save(alternativa_2);
		
		List<Alternativa> todasAlternativas = alternativaController.findAll();
		
		assertNotNull(todasAlternativas);
	}
}
