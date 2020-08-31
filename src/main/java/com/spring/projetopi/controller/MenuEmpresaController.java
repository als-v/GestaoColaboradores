package com.spring.projetopi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.service.EmpresaService;

@Controller
public class MenuEmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	@RequestMapping(value = "/menuEmpresa/{id}", method = RequestMethod.GET)
	public ModelAndView GoToMenu(@PathVariable("id") Long id) {	
		ModelAndView mv = new ModelAndView("menuEmpresa");
		Empresa empresa = empresaService.findById(id);
		mv.addObject("empresa", empresa);
	    return mv;
	}
}
