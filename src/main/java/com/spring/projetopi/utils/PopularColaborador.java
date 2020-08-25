package com.spring.projetopi.utils;

import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.repository.EmpresaRepository;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class PopularColaborador {
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
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
	public void criarColaborador() {
		
		Empresa emp1 = new Empresa();
		emp1.setCnpj("22.233.244/0001-04");
		emp1.setEmail("wolks@sac.com");
		emp1.setNome("WOLKSWAGENS");
		emp1.setSenha("123456");
		Empresa e = empresaRepository.save(emp1);
		
		List<Colaborador> colaboradorList = new ArrayList<>();
		
		Colaborador c1 = new Colaborador();
		c1.setEmail("teste@teste.com");
		c1.setNome("Teste da TEste TESTES");
		c1.setSenha("AAAASASAS");
		c1.setEmpresa(e);
		
		Colaborador c2 = new Colaborador();
		c2.setEmail("reginaldo@teste.com");
		c2.setNome("Reginaldo");
		c2.setSenha("senha12345779");
		c2.setEmpresa(e);
		
		Colaborador c3 = new Colaborador();
		c3.setEmail("asdasd@asdasdas.com");
		c3.setNome("MEU NOME");
		c3.setSenha("12345678");
		c3.setEmpresa(e);
		
		colaboradorList.add(c1);
		colaboradorList.add(c2);
		colaboradorList.add(c3);
			
		for(Colaborador c: colaboradorList) {
			Colaborador cSaved = colaboradorRepository.save(c);
			System.out.println(cSaved.getColaborador_id());
		}
	}
}
