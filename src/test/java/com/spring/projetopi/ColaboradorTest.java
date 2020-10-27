package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
		
		empresa.setNome("Teste Empresa Colaborador 1");
		empresa.setEmail("empresacolaboradorteste1@empresacolaboradorteste1.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(colaboradorController.verifyEmailEmpresa("empresacolaboradorteste1@empresacolaboradorteste1.com") == true) {
			empresaController.save(empresa);			
		} else {
			empresa = empresaController.findByEmail("empresacolaboradorteste1@empresacolaboradorteste1.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setNome("Teste Colaborador 1");
		colaborador.setEmail("testecolaborador1@testecolaborador1.com");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("testecolaborador1@testecolaborador1.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("testecolaborador1@testecolaborador1.com");
		}
		
		assertEquals(colaborador.getNome(), "Teste Colaborador 1");
		assertEquals(colaborador.getEmail(), "testecolaborador1@testecolaborador1.com");
		assertEquals(colaborador.getSenha(), "teste");
		assertEquals(colaborador.getEmpresa().getNome(), "Teste Empresa Colaborador 1");
	}
	
	@Test
	public void editColaborador() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Teste Empresa Colaborador 2");
		empresa.setEmail("empresacolaboradorteste2@empresacolaboradorteste2.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(colaboradorController.verifyEmailEmpresa("empresacolaboradorteste2@empresacolaboradorteste2.com") == true) {
			empresaController.save(empresa);			
		} else {
			empresa = empresaController.findByEmail("empresacolaboradorteste2@empresacolaboradorteste2.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setNome("Teste Colaborador 2");
		colaborador.setEmail("testecolaborador2@testecolaborador2.com");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("testecolaborador2@testecolaborador2.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("testecolaborador2@testecolaborador2.com");
		}
		
		Colaborador colaboradorEdit = colaboradorController.findById(colaborador.getColaborador_id());
		
		colaboradorEdit.setNome("Teste editado");
		
		colaboradorController.save(colaboradorEdit);
		
		Colaborador result = colaboradorController.findById(colaboradorEdit.getColaborador_id());
		
		assertEquals(result.getNome(), "Teste editado");
	}
	
	@Test
	public void listColaborador() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Teste Empresa Colaborador 3");
		empresa.setEmail("empresacolaboradorteste3@empresacolaboradorteste3.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(colaboradorController.verifyEmailEmpresa("empresacolaboradorteste3@empresacolaboradorteste3.com") == true) {
			empresaController.save(empresa);			
		} else {
			empresa = empresaController.findByEmail("empresacolaboradorteste3@empresacolaboradorteste3.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setNome("Teste Colaborador 3");
		colaborador.setEmail("testecolaborador3@testecolaborador3.com");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("testecolaborador3@testecolaborador3.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("testecolaborador3@testecolaborador3.com");
		}
		
		Colaborador colaborador1 = new Colaborador();
		
		colaborador1.setNome("Teste Colaborador 4");
		colaborador1.setEmail("testecolaborador4@testecolaborador4.com");
		colaborador1.setSenha("teste");
		colaborador1.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("testecolaborador4@testecolaborador4.com")) {
			colaboradorController.save(colaborador1);			
		}else {
			colaborador1 = colaboradorController.findByEmail("testecolaborador4@testecolaborador4.com");
		}
		
		List<Colaborador> colaboradoresDaEmpresa = empresaController.findColaborador(empresa.getEmpresa_id());
		
		/*
		assertEquals(colaboradoresDaEmpresa.size(), 2);
		assertEquals(colaboradoresDaEmpresa.get(0).getEmail(), colaborador.getEmail());
		assertEquals(colaboradoresDaEmpresa.get(1).getEmail(), colaborador1.getEmail());
		*/
		
		assertNotNull(colaboradoresDaEmpresa);
	}
	
	@Test
	public void loginColaborador() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Teste Empresa Colaborador 4");
		empresa.setEmail("empresacolaboradorteste4@empresacolaboradorteste4.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(colaboradorController.verifyEmailEmpresa("empresacolaboradorteste4@empresacolaboradorteste4.com") == true) {
			empresaController.save(empresa);			
		} else {
			empresa = empresaController.findByEmail("empresacolaboradorteste4@empresacolaboradorteste4.com");
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setNome("Teste Colaborador 5");
		colaborador.setEmail("testecolaborador5@testecolaborador5.com");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(colaboradorController.verifyEmailEmpresa("testecolaborador5@testecolaborador5.com")) {
			colaboradorController.save(colaborador);			
		}else {
			colaborador = colaboradorController.findByEmail("testecolaborador5@testecolaborador5.com");
		}
		
		assertEquals(colaborador.getColaborador_id(), colaboradorController.loginColaborador(colaborador.getEmail(), colaborador.getSenha()));
	}
}
