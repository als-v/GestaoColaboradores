package com.spring.projetopi.controller;

import com.spring.projetopi.model.Pesquisa;

import java.util.List;

public interface PesquisaController {

	List<Pesquisa> findAll();
	Pesquisa findById(long id);
	Pesquisa save(Pesquisa pesquisa);
}
