package com.spring.projetopi.controller.controllerImpl;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.RealizacaoPesquisa;
import com.spring.projetopi.controller.RealizacaoPesquisaController;
import com.spring.projetopi.repository.ColaboradorRepository;
import com.spring.projetopi.repository.PesquisaRepository;
import com.spring.projetopi.repository.RealizacaoPesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealizacaoPesquisaControllerImpl implements RealizacaoPesquisaController {

	@Autowired
	RealizacaoPesquisaRepository realizacaoPesquisaRepository;
	
	@Autowired
	PesquisaRepository pesquisaRepository;
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@Override
	public List<RealizacaoPesquisa> findAll() {
		return realizacaoPesquisaRepository.findAll();
	}

	@Override
	public RealizacaoPesquisa findById(long id) {
		return realizacaoPesquisaRepository.findById(id).get();
	}

	@Override
	public RealizacaoPesquisa save(RealizacaoPesquisa realizacaoPesquisa) {
		return realizacaoPesquisaRepository.save(realizacaoPesquisa);
	}

	@Override
	public Pesquisa getPesquisa(Colaborador colaborador) {
		List<Pesquisa> todasPesquisas = pesquisaRepository.findAll();
		List<Pesquisa> colabPesquisas = new ArrayList<Pesquisa>();
		
		for(int i = 0; i < todasPesquisas.size(); i++) {
			if(todasPesquisas.get(i).getEmpresa().getEmpresa_id() == colaborador.getEmpresa().getEmpresa_id()) {
				colabPesquisas.add(todasPesquisas.get(i));
			}
		}
		
		List<RealizacaoPesquisa> pesquisasFeitas = realizacaoPesquisaRepository.findAll();
		
		if(pesquisasFeitas.size() == 0) {
			return colabPesquisas.get(0);
		}else {
				for(int i = 0; i < colabPesquisas.size(); i++) {
					int flag = 0;
					for(int j = 0; j < pesquisasFeitas.size(); j++) {
						if((colabPesquisas.get(i).getPesquisa_id() == pesquisasFeitas.get(j).getPesquisa().getPesquisa_id()) && (pesquisasFeitas.get(j).getColaborador().getColaborador_id() == colaborador.getColaborador_id())) {
							flag = 1;
						}
					}
					if(flag == 0) {
						return colabPesquisas.get(i);
					}
				}
		}
		
		return null;
	}
	
}