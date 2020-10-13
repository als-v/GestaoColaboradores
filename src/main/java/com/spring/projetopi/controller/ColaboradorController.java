package com.spring.projetopi.controller;

import com.spring.projetopi.model.Colaborador;

import java.util.List;

public interface ColaboradorController {
	
	List<Colaborador> findAll();
	Colaborador findById(long id);
	Colaborador save(Colaborador colaborador);
	long loginColaborador(String email, String senha);
	boolean verifyEmailEmpresa(String email);
}
