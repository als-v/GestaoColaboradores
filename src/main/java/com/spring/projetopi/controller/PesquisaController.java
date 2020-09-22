package com.spring.projetopi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.service.PesquisaService;

@Controller
public class PesquisaController {

	@Autowired
	PesquisaService pesquisaService;
	
	@RequestMapping(value = "/pesquisas/{id}", method = RequestMethod.GET)
	public ModelAndView getPesquisas(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pesquisa");
		List<Pesquisa> pesquisas = pesquisaService.findAll();
		
		for(int i = 0; i < pesquisas.size(); i++) {
			if(pesquisas.get(i).getEmpresa().getEmpresa_id() != id) {
				pesquisas.remove(i);
				i = -1;
			}
		}
		
		mv.addObject("pesquisas", pesquisas);
		
		return mv;
	}	
}
