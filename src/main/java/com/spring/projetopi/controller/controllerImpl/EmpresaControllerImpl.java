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

	@Override
	public List<Colaborador> findColaborador(long id) {
		List<Colaborador> colaboradores = colaboradorRepository.findAll();
		
		for(int i = 0; i < colaboradores.size(); i++) {
			if(colaboradores.get(i).getEmpresa().getEmpresa_id() != id) {
				colaboradores.remove(i);
				i = -1;
			}
		}
		
		return colaboradores;
	}

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
