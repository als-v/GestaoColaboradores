package com.spring.projetopi.controller.controllerImpl;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.repository.ColaboradorRepository;
import com.spring.projetopi.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorControllerImpl implements ColaboradorController {
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Override
	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}

	@Override
	public Colaborador findById(long id) {
		return colaboradorRepository.findById(id).get();
	}
	
	@Override
	public Colaborador findByEmail(String email) {
		List<Colaborador> colaboradores = colaboradorRepository.findAll();
		
		for(int i = 0; i < colaboradores.size(); i++) {
			if(email.equals(colaboradores.get(i).getEmail())) {
				return colaboradores.get(i);
			}
		}
		
		return null;
	}

	@Override
	public Colaborador save(Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	}

	@Override
	public long loginColaborador(String email, String senha) {
    	List<Colaborador> colaboradores = colaboradorRepository.findAll();
        
        for(int i = 0; i < colaboradores.size(); i++) {
        	if(email.equals(colaboradores.get(i).getEmail()) && senha.equals(colaboradores.get(i).getSenha())) {
        		return colaboradores.get(i).getColaborador_id();
        	}else if(email.equals(colaboradores.get(i).getEmail()) && !senha.equals(senha.contentEquals(colaboradores.get(i).getSenha()))) {
        		return -2;
        	}
        }
        
		return -1;
	}

	@Override
	public boolean verifyEmailEmpresa(String email) {
		List<Empresa> empresas = empresaRepository.findAll();
		List<Colaborador> colaboradores = colaboradorRepository.findAll();
		
		for(int i = 0; i < empresas.size(); i++) {
			if(email.equals(empresas.get(i).getEmail())) {
				return false;
			}
		}
		
		for(int i = 0; i < colaboradores.size(); i++) {
			if(email.equals(colaboradores.get(i).getEmail())) {
				return false;
			}
		}
		
		return true;
	}

}
