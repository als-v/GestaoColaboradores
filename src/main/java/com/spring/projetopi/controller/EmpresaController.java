package com.spring.projetopi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	@RequestMapping(value = "/empresas", method = RequestMethod.GET)
	public ModelAndView getEmpresa() {
		ModelAndView mv = new ModelAndView("empresas");
		List<Empresa> empresas = empresaService.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String getEmpresaForm() {
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String saveEmpresa(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "redirect:/cadastro";
		}
		
		empresaService.save(empresa);
		return "redirect:/empresas";
	}
}
