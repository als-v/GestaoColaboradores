package com.spring.projetopi.service.serviceImpl;

import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.service.AlternativaService;
import com.spring.projetopi.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativaServiceImpl implements AlternativaService {

	@Autowired
	AlternativaRepository alternativaRepository;
	
	@Override
	public List<Alternativa> findAll() {
		return alternativaRepository.findAll();
	}

	@Override
	public Alternativa findById(long id) {
		return alternativaRepository.findById(id).get();
	}

	@Override
	public Alternativa save(Alternativa alternativa) {
		return alternativaRepository.save(alternativa);
	}

}
