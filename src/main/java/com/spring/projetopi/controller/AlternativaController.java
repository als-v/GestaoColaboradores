package com.spring.projetopi.controller;

import com.spring.projetopi.model.Alternativa;

import java.util.List;

public interface AlternativaController {
	
	List<Alternativa> findAll();
	Alternativa findById(long id);
	Alternativa save(Alternativa alternativa);
}
