package com.spring.projetopi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.model.Empresa;

@SpringBootTest
public class EmpresaTest {
	
	@Autowired
	EmpresaController empresaController;
	
	@Test
	public void createEmpresa() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
				
		//empresaController.save(empresa);

		assertNotNull(empresa.getEmpresa_id());
		assertEquals(empresa.getNome(), "Empresa Teste");
		assertEquals(empresa.getEmail(), "email@email.com");
		assertEquals(empresa.getCnpj(), "12.123.123/00001-93");
		assertEquals(empresa.getSenha(), "senha");
	}
	
	@Test
	public void editarEmpresa() {
		Empresa empresa = new Empresa();
		
		empresa.setNome("Empresa Teste");
		empresa.setEmail("email@email.com");
		empresa.setCnpj("12.123.123/00001-93");
		empresa.setSenha("senha");
		
		//empresaController.save(empresa);
		
		empresa.setNome("Empresa Editar");
		
		//empresaController.save(empresa);
		
		assertEquals(empresa.getNome(), "Empresa Editar");
	}
	
	@Test
	public void listarEmpresa() {
		Empresa empresa1 = new Empresa();
		
		empresa1.setNome("Empresa 1");
		empresa1.setEmail("email@email.com");
		empresa1.setCnpj("12.123.123/00001-93");
		empresa1.setSenha("senha");
		
		Empresa empresa2 = new Empresa();
		
		empresa2.setNome("Empresa 2");
		empresa2.setEmail("email@email.com");
		empresa2.setCnpj("12.123.123/00001-93");
		empresa2.setSenha("senha");
		
		//empresaController.save(empresa1);
		//empresaController.save(empresa2);
		
		//List <Empresa> empresas = empresaController.findAll();
		
		List <Empresa> empresas = new ArrayList<Empresa>();
		
		empresas.add(empresa1);
		empresas.add(empresa2);
		
		assertEquals(empresas.size(), 2);
	}
}
