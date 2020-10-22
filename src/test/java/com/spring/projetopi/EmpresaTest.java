package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;

@SpringBootTest
public class EmpresaTest {
	
	@Autowired
	EmpresaController empresaController;
	
	@Autowired
	ColaboradorController colaboradorController;
	
	@Test
	public void createEmpresa() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste 1");
		empresa.setEmail("empresateste1@empresateste1.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste1@empresateste1.com") == true) {			
			empresaController.save(empresa);
		}

		assertNotNull(empresa.getEmpresa_id());
		assertEquals(empresa.getNome(), "Empresa Teste 1");
		assertEquals(empresa.getEmail(), "empresateste1@empresateste1.com");
		assertEquals(empresa.getCnpj(), "00.000.000/00000-00");
		assertEquals(empresa.getSenha(), "senha");
	}
	
	@Test
	public void editarEmpresa() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste 2");
		empresa.setEmail("empresateste2@empresateste2.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		Empresa empresaEdit = new Empresa();
		
		if(empresaController.verifyEmailColab("empresateste2@empresateste2.com") == true) {			
			empresaController.save(empresa);
			empresaEdit = empresaController.findById(empresa.getEmpresa_id());
		}else {
			empresaEdit = empresaController.findByEmail("empresateste2@empresateste2.com");
		}
		
		empresaEdit.setNome("Empresa Editar");
		
		empresaController.save(empresaEdit);
		
		empresa = empresaController.findByEmail("empresateste2@empresateste2.com");
		
		assertEquals(empresa.getNome(), empresaEdit.getNome());
	}
	
	@Test
	public void listarEmpresa() {
		Empresa empresa1 = new Empresa();
		
		empresa1.setNome("Empresa Teste 3");
		empresa1.setEmail("empresateste3@empresateste3.com");
		empresa1.setCnpj("00.000.000/00000-00");
		empresa1.setSenha("senha");
		
		Empresa empresa2 = new Empresa();
		
		empresa2.setNome("Empresa Teste 4");
		empresa2.setEmail("empresateste4@empresateste4.com");
		empresa2.setCnpj("00.000.000/00000-00");
		empresa2.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste3@empresateste3.com") == true) {			
			empresaController.save(empresa1);
		}
		
		if(empresaController.verifyEmailColab("empresateste4@empresateste4.com") == true) {			
			empresaController.save(empresa2);
		}
		
		List <Empresa> empresas = empresaController.findAll();
		
		assertNotNull(empresas);
	}
	
	@Test
	public void loginEmpresa() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste 5");
		empresa.setEmail("empresateste5@empresateste5.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste5@empresateste5.com") == true) {
			empresaController.save(empresa);			
		}else {
			empresa = empresaController.findByEmail("empresateste5@empresateste5.com");
		}
		
		assertEquals(empresa.getEmpresa_id(), empresaController.loginEmpresa(empresa.getEmail(), empresa.getSenha()));
	}
	
	@Test
	public void emailEmpresaTest() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Teste Teste 6");
		empresa.setEmail("empresateste6@empresateste6.com");
		empresa.setCnpj("00.000.000/00000-00");
		empresa.setSenha("senha");
		
		if(empresaController.verifyEmailColab("empresateste6@empresateste6.com") == true) {
			empresaController.save(empresa);			
		}
		
		Colaborador colaborador = new Colaborador();
		
		colaborador.setEmail("colaboradorempresa1@colaboradorempresa1.com");
		colaborador.setNome("Teste Colaborador Empresa 1");
		colaborador.setSenha("teste");
		colaborador.setEmpresa(empresa);
		
		if(empresaController.verifyEmailColab("colaboradorempresa1@colaboradorempresa1.com") == true) {
			colaboradorController.save(colaborador);			
		}
		
		assertFalse(empresaController.verifyEmailColab(empresa.getEmail()));
		assertFalse(empresaController.verifyEmailColab(colaborador.getEmail()));
		assertTrue(empresaController.verifyEmailColab("esperoqueninguemtenhaesseemailparateste@tetetetdasdfad.com"));
	}
}
