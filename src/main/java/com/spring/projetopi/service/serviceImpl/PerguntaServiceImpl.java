package com.spring.projetopi.service.serviceImpl;

import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.service.PerguntaService;
import com.spring.projetopi.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaServiceImpl implements PerguntaService {

	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Override
	public List<Pergunta> findAll() {
		return perguntaRepository.findAll();
	}

	@Override
	public Pergunta findById(long id) {
		return perguntaRepository.findById(id).get();
	}

	@Override
	public Pergunta save(Pergunta pergunta) {
		return perguntaRepository.save(pergunta);
	}
	
}
