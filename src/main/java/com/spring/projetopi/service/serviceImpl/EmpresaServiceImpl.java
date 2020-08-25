package com.spring.projetopi.service.serviceImpl;

import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.service.EmpresaService;
import com.spring.projetopi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	public Empresa findById(long id) {
		return empresaRepository.findById(id).get();
	}

	@Override
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
}
