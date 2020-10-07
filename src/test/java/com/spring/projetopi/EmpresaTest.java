package com.spring.projetopi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.service.EmpresaService;

@SpringBootTest
public class EmpresaTest {
	
	@Autowired
	EmpresaService empresaService;
	
	@Test
	public void createEmpresa() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
				
		//empresaService.save(empresa);

		assertNotNull(empresa.getEmpresa_id());
		assertEquals(empresa.getNome(), "Empresa Teste");
		assertEquals(empresa.getEmail(), "email@email.com");
		assertEquals(empresa.getCnpj(), "12.123.123/00001-93");
		assertEquals(empresa.getSenha(), "senha");
	}
}
