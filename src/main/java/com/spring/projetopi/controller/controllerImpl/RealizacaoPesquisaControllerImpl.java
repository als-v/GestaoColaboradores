package com.spring.projetopi.controller.controllerImpl;

import com.spring.projetopi.model.RealizacaoPesquisa;
import com.spring.projetopi.controller.RealizacaoPesquisaController;
import com.spring.projetopi.repository.RealizacaoPesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealizacaoPesquisaControllerImpl implements RealizacaoPesquisaController {

	@Autowired
	RealizacaoPesquisaRepository realizacaoPesquisaRepository;
	
	@Override
	public List<RealizacaoPesquisa> findAll() {
		return realizacaoPesquisaRepository.findAll();
	}

	@Override
	public RealizacaoPesquisa findById(long id) {
		return realizacaoPesquisaRepository.findById(id).get();
	}

	@Override
	public RealizacaoPesquisa save(RealizacaoPesquisa realizacaoPesquisa) {
		return realizacaoPesquisaRepository.save(realizacaoPesquisa);
	}
	
}