package com.spring.projetopi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.service.ColaboradorService;
import com.spring.projetopi.service.EmpresaService;

@SpringBootTest
public class ColaboradorTest {
	
	@Autowired
	ColaboradorService colaboradorService;
	
	@Autowired
	EmpresaService empresaService;
	
	@Test
	public void createColaborador() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		//empresaService.save(empresa);
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		//colaboradorService.save(colaborador);
		
		assertEquals(colaborador.getEmail(), "teste@teste.com");
		assertEquals(colaborador.getNome(), "Teste");
		assertEquals(colaborador.getSenha(), "teste");
		assertEquals(colaborador.getEmpresa().getNome(), "Empresa Teste");
	}
}
