package com.spring.projetopi.service.serviceImpl;

import com.spring.projetopi.model.RealizacaoPesquisa;
import com.spring.projetopi.service.RealizacaoPesquisaService;
import com.spring.projetopi.repository.RealizacaoPesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealizacaoPesquisaServiceImpl implements RealizacaoPesquisaService {

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