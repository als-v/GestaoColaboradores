package com.spring.projetopi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.PesquisaController;
import com.spring.projetopi.controller.RealizacaoPesquisaController;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.RealizacaoPesquisa;

@Controller
public class PesquisaService {

	@Autowired
	PesquisaController pesquisaController;
	
	@Autowired
	ColaboradorController colaboradorController;
	
	@Autowired
	RealizacaoPesquisaController realizacaoPesquisaController;
	
	@RequestMapping(value = "/pesquisas/{id}", method = RequestMethod.GET)
	public ModelAndView getPesquisas(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pesquisa");
		List<Pesquisa> pesquisas = pesquisaController.findAll();
		
		for(int i = 0; i < pesquisas.size(); i++) {
			if(pesquisas.get(i).getEmpresa().getEmpresa_id() != id) {
				pesquisas.remove(i);
				i = -1;
			}
		}
		
		mv.addObject("pesquisas", pesquisas);
		
		return mv;
	}	
	
	@RequestMapping(value = "/realizarPesquisa/{id}", method = RequestMethod.GET)
	public ModelAndView getColaboradorPesquisas(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pesquisaColaborador");
		List<Pesquisa> pesquisas = pesquisaController.findAll();
		Colaborador colab = colaboradorController.findById(id);
		
		for(int i = 0; i < pesquisas.size(); i++) {
			if(pesquisas.get(i).getEmpresa().getEmpresa_id() != colab.getEmpresa().getEmpresa_id()) {
				pesquisas.remove(i);
				i = -1;
			}
		}
		
		mv.addObject("pesquisas", pesquisas);
		
		return mv;
	}	
	
	@RequestMapping(value = "/realizarPesquisa/{id1}/{id2}", method = RequestMethod.GET)
	public ModelAndView doPesquisa(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
		ModelAndView mv = new ModelAndView("realizarPesquisa");
		Pesquisa pesquisa = pesquisaController.findById(id2);
		
		mv.addObject("pesquisa", pesquisa);
		
		return mv;
	}
	
	@RequestMapping(value = "/realizarPesquisa/{id1}/{id2}", method = RequestMethod.POST)
	public String resultPesquisa(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
		Colaborador colaborador = colaboradorController.findById(id1);
		Pesquisa pesquisa = pesquisaController.findById(id2);
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa);
		realizacaoPesquisa.setAcertos(12);
		realizacaoPesquisa.setErros(3);
		
		realizacaoPesquisaController.save(realizacaoPesquisa);
		
		return "redirect:/menuColaborador/" + id1;
	}
}
