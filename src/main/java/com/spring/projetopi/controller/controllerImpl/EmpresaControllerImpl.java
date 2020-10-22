package com.spring.projetopi.controller.controllerImpl;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.repository.ColaboradorRepository;
import com.spring.projetopi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaControllerImpl implements EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	// Busca todas as empresas
	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	// Busca empresa por id
	@Override
	public Empresa findById(long id) {
		return empresaRepository.findById(id).get();
	}
	
	// Busca empresa pelo e-mail
	@Override
	public Empresa findByEmail(String email) {
		List<Empresa> empresas = empresaRepository.findAll();
		
		for(int i = 0; i < empresas.size(); i++) {
			if(email.equals(empresas.get(i).getEmail())) {
				return empresas.get(i);
			}
		}
		
		return null;
	}

	// Cadastra empresa no banco
	@Override
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	// Acha todos os colaboradores da empresa
	@Override
	public List<Colaborador> findColaborador(long id) {
		List<Colaborador> colaboradores = colaboradorRepository.findAll();
		List<Colaborador> empresaColab = new ArrayList<Colaborador>();
		
		for(int i = 0; i < colaboradores.size(); i++) {
			if(colaboradores.get(i).getEmpresa().getEmpresa_id() == id) {
				empresaColab.add(colaboradores.get(i));
			}
		}
		
		return empresaColab;
	}

	// Realiza o login
	@Override
	public long loginEmpresa(String email, String senha) {
		List<Empresa> empresas = empresaRepository.findAll();
		
		for(int i = 0; i < empresas.size(); i++) {
        	if(email.equals(empresas.get(i).getEmail()) && senha.equals(empresas.get(i).getSenha())) {
                return empresas.get(i).getEmpresa_id();
        	}else if(email.equals(empresas.get(i).getEmail()) && !senha.equals(empresas.get(i).getSenha())) {
        		return -2;
        	}
        }
		
		return -1;
	}

	// Verifica o e-mail
	@Override
	public boolean verifyEmailColab(String email) {
		List<Colaborador> colaboradores = colaboradorRepository.findAll();
		List<Empresa> empresas = empresaRepository.findAll();
		
		for(int i = 0; i < colaboradores.size(); i++) {
			if(email.equals(colaboradores.get(i).getEmail())) {
				return false;
			}
		}
		
		for(int i = 0; i < empresas.size(); i++) {
			if(email.equals(empresas.get(i).getEmail())) {
				return false;
			}
		}
		
		return true;
	}
	
}
