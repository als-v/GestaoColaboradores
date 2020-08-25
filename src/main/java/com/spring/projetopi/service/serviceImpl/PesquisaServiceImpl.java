package com.spring.projetopi.service.serviceImpl;

import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.service.PesquisaService;
import com.spring.projetopi.repository.PesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesquisaServiceImpl implements PesquisaService {

	@Autowired
	PesquisaRepository pesquisaRepository;
	
	@Override
	public List<Pesquisa> findAll() {
		return pesquisaRepository.findAll();
	}

	@Override
	public Pesquisa findById(long id) {
		return pesquisaRepository.findById(id).get();
	}

	@Override
	public Pesquisa save(Pesquisa pesquisa) {
		return pesquisaRepository.save(pesquisa);
	}
	
}