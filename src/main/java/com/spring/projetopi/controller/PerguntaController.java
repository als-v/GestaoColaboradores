package com.spring.projetopi.controller;

import com.spring.projetopi.model.Pergunta;

import java.util.List;

public interface PerguntaController {
	
	List<Pergunta> findAll();
	Pergunta findById(long id);
	Pergunta save(Pergunta pergunta);
}
