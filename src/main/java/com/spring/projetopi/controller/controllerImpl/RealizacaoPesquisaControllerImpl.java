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
	
	@Override
	public List<Boolean> checkValues(List<Boolean> list){
		List<Boolean> check = new ArrayList<Boolean>();
		
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i) == false) {
				check.add(false);
			} else {
				check.add(true);
				i = i + 1;
			}
		}
		
		return list;
	}
	
	@Override
	public List<Integer> calcAcertos(Pesquisa pesquisa, List<Boolean> values){
		List<Integer> calculo = new ArrayList<Integer>();
		
		int acertos = 0;
		int erros = 0;
		
		for(int i = 0; i < pesquisa.getQuestoes().size(); i++) {
			for(int j = 0; j < pesquisa.getQuestoes().get(i).getAlternativas().size(); j++) {
				if(pesquisa.getQuestoes().get(i).getAlternativas().get(j).isCorreto() == true && values.get(j) == true) {
					acertos = acertos + 1;
				}else if (pesquisa.getQuestoes().get(i).getAlternativas().get(j).isCorreto() == false && values.get(j) == false){
					acertos = acertos + 1;
				} else {
					erros = erros + 1;
				}
			}
		}
		
		calculo.add(acertos);
		calculo.add(erros);
		
		return calculo;
	}

	@Override
	public float calcPorcentagemAcertos(int acertos, int questoes) {
		return ((acertos*100)/questoes);
	}

	@Override
	public float calcPorcentagemErro(float porcentagemAcerto) {
		float result = 100;
		return result - porcentagemAcerto;
	}
	
}