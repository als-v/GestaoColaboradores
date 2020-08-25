package com.spring.projetopi.service;

import com.spring.projetopi.model.Colaborador;

import java.util.List;

public interface ColaboradorService {
	
	List<Colaborador> findAll();
	Colaborador findById(long id);
	Colaborador save(Colaborador colaborador);
}
