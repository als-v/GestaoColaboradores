package com.spring.projetopi.controller.controllerImpl;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorControllerImpl implements ColaboradorController {
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@Override
	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}

	@Override
	public Colaborador findById(long id) {
		return colaboradorRepository.findById(id).get();
	}

	@Override
	public Colaborador save(Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	}

}
