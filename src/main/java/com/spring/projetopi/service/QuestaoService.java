package com.spring.projetopi.service;

import com.spring.projetopi.model.Questao;

import java.util.List;

public interface QuestaoService {

	List<Questao> findAll();
	Questao findById(long id);
	Questao save(Questao questao);
}
