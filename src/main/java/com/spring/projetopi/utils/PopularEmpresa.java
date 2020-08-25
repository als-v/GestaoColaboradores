package com.spring.projetopi.utils;

import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class PopularEmpresa {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
		/* 
	 * 
	 * === DESCOMENTE A LINHA ABAIXO PARA O 'SCRIPT' FUNCIONAR ===
	 * 	Apos o uso, comente novamente, se não a cada vez que o
	 * 	projeto rodar, irá adicionar os dados novamente.
	 * 
	 	*/
	
	//@PostConstruct
	public void criarEmpresa() {
		
		List<Empresa> empresaList = new ArrayList<>();
		
		Empresa emp1 = new Empresa();
		emp1.setCnpj("22.233.244/0001-04");
		emp1.setEmail("teste@teste.com");
		emp1.setNome("TESTE");
		emp1.setSenha("teste123");
		
		Empresa emp2 = new Empresa();
		emp2.setCnpj("89.324.523/0001-34");
		emp2.setEmail("primos@primos.com");
		emp2.setNome("PRIMOS");
		emp2.setSenha("primos");
		
		empresaList.add(emp1);
		empresaList.add(emp2);
		
		for(Empresa empresa: empresaList) {
			Empresa empresaSaved = empresaRepository.save(empresa);
			System.out.println(empresaSaved.getEmpresa_id());
		}
	}
}
