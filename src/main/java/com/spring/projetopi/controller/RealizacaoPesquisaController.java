package com.spring.projetopi.controller;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.RealizacaoPesquisa;

import java.util.List;

public interface RealizacaoPesquisaController {

	List<RealizacaoPesquisa> findAll();
	RealizacaoPesquisa findById(long id);
	RealizacaoPesquisa save(RealizacaoPesquisa realizacaoPesquisa);
	Pesquisa getPesquisa(Colaborador colaborador);
	List<Boolean> checkValues(List<Boolean> list);
	List<Integer> calcAcertos(Pesquisa pesquisa, List<Boolean> values);
}
