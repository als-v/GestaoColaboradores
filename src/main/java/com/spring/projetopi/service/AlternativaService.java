package com.spring.projetopi.service;

import com.spring.projetopi.model.Alternativa;

import java.util.List;

public interface AlternativaService {
	
	List<Alternativa> findAll();
	Alternativa findById(long id);
	Alternativa save(Alternativa alternativa);
}
