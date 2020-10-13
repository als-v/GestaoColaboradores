package com.spring.projetopi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;

@Controller
public class MenuEmpresaService {
	
	@Autowired
	EmpresaController empresaController;
	
	@Autowired
	ColaboradorController colaboradorController;
	
	@RequestMapping(value = "/menuEmpresa/{id}", method = RequestMethod.GET)
	public ModelAndView GoToMenuEmp(@PathVariable("id") Long id) {	
		ModelAndView mv = new ModelAndView("menuEmpresa");
		Empresa empresa = empresaController.findById(id);
		mv.addObject("empresa", empresa);
	    return mv;
	}
	
	@RequestMapping(value = "/menuColaborador/{id}", method = RequestMethod.GET)
	public ModelAndView GoToMenuColab(@PathVariable("id") Long id) {	
		ModelAndView mv = new ModelAndView("menuColaborador");
		Colaborador colaborador = colaboradorController.findById(id);
		mv.addObject("colaborador", colaborador);
	    return mv;
	}
}
