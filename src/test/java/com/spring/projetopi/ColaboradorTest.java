package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;

@SpringBootTest
public class ColaboradorTest {
	
	@Autowired
	ColaboradorController colaboradorController;
	
	@Autowired
	EmpresaController empresaController;
	
	@Test
	public void createColaborador() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		//empresaController.save(empresa);
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		//colaboradorController.save(colaborador);
		
		assertEquals(colaborador.getEmail(), "teste@teste.com");
		assertEquals(colaborador.getNome(), "Teste");
		assertEquals(colaborador.getSenha(), "teste");
		assertEquals(colaborador.getEmpresa().getNome(), "Empresa Teste");
	}
	
	@Test
	public void editColaborador() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		//empresaController.save(empresa);
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("teste@teste.com");
		colaborador.setNome("Teste");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		//colaboradorController.save(colaborador);
		
		colaborador.setNome("Teste editado");
		
		//colaboradorController.save(colaborador);
		
		assertEquals(colaborador.getNome(), "Teste editado");
	}
}
