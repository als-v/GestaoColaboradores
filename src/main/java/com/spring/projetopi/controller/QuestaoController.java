package com.spring.projetopi.controller;

import com.spring.projetopi.model.Questao;

import java.util.List;

public interface QuestaoController {

	List<Questao> findAll();
	Questao findById(long id);
	Questao save(Questao questao);
}
