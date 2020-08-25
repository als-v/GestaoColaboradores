package com.spring.projetopi.service;

import com.spring.projetopi.model.Empresa;

import java.util.List;

public interface EmpresaService {

	List<Empresa> findAll();
	Empresa findById(long id);
	Empresa save(Empresa empresa);
}
