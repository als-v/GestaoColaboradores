package com.spring.projetopi.controller;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;

import java.util.List;

public interface EmpresaController {

	List<Empresa> findAll();
	List<Colaborador> findColaborador(long id);
	Empresa findById(long id);
	Empresa findByEmail(String email);
	Empresa save(Empresa empresa);
	long loginEmpresa(String email, String senha);
	boolean verifyEmailColab(String email);
}
