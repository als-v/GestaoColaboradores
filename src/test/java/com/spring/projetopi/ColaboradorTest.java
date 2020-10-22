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
}
