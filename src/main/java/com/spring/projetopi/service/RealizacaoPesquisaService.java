package com.spring.projetopi.service;

import com.spring.projetopi.model.RealizacaoPesquisa;

import java.util.List;

public interface RealizacaoPesquisaService {

	List<RealizacaoPesquisa> findAll();
	RealizacaoPesquisa findById(long id);
	RealizacaoPesquisa save(RealizacaoPesquisa realizacaoPesquisa);
}
