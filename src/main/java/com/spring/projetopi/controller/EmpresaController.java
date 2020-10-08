package com.spring.projetopi.controller;

import com.spring.projetopi.model.Empresa;

import java.util.List;

public interface EmpresaController {

	List<Empresa> findAll();
	Empresa findById(long id);
	Empresa save(Empresa empresa);
}
