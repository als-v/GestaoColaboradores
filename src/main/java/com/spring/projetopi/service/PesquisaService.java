package com.spring.projetopi.service;

import com.spring.projetopi.model.Pesquisa;

import java.util.List;

public interface PesquisaService {

	List<Pesquisa> findAll();
	Pesquisa findById(long id);
	Pesquisa save(Pesquisa pesquisa);
}
