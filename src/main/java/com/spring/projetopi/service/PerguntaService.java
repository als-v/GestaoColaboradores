package com.spring.projetopi.service;

import com.spring.projetopi.model.Pergunta;

import java.util.List;

public interface PerguntaService {
	
	List<Pergunta> findAll();
	Pergunta findById(long id);
	Pergunta save(Pergunta pergunta);
}
