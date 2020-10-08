package com.spring.projetopi.controller;

import com.spring.projetopi.model.RealizacaoPesquisa;

import java.util.List;

public interface RealizacaoPesquisaController {

	List<RealizacaoPesquisa> findAll();
	RealizacaoPesquisa findById(long id);
	RealizacaoPesquisa save(RealizacaoPesquisa realizacaoPesquisa);
}
