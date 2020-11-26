package com.spring.projetopi.controller;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.RealizacaoPesquisa;

import java.util.List;

public interface RealizacaoPesquisaController {

	List<RealizacaoPesquisa> findAll();
	List<RealizacaoPesquisa> findByColaborador(Colaborador colaborador);
	RealizacaoPesquisa findById(long id);
	RealizacaoPesquisa save(RealizacaoPesquisa realizacaoPesquisa);
	Pesquisa getPesquisa(Colaborador colaborador);
	List<Boolean> checkValues(List<Boolean> list);
	List<Integer> calcAcertos(Pesquisa pesquisa, List<Boolean> values);
	float calcPorcentagemAcertos(int acertos, int questoes);
	float calcPorcentagemErro(float porcentagemAcerto);
	List<RealizacaoPesquisa> getPesquisas(Pesquisa p);
	List<Pesquisa> calcResultados();
	List<RealizacaoPesquisa> findByEmpresa(Empresa emp);
}
