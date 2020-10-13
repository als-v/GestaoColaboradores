package com.spring.projetopi.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.model.Empresa;

@Controller
public class EmpresaService {
	
	@Autowired
	EmpresaController empresaController;
	
	/*
	 * Listagem das empresas (apenas para fins de teste)
	 */
	
	@RequestMapping(value = "/empresas", method = RequestMethod.GET)
	public ModelAndView getEmpresa() {
		ModelAndView mv = new ModelAndView("empresas");
		List<Empresa> empresas = empresaController.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}
	
	/* 
	 * Cadastro de empresa
	 */
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String getEmpresaForm() {
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String saveEmpresa(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
			return "redirect:/cadastro";
		}
		
		if (!empresaController.verifyEmailColab(empresa.getEmail())) {
			attributes.addFlashAttribute("mensagem", "E-mail já cadastrado no sistema, por favor tente novamente!");
			return "redirect:/cadastro";
		}
		
		empresaController.save(empresa);	
		return "redirect:/menuEmpresa/" + empresa.getEmpresa_id();
	}
	
	/*
	 * Edição da empresa
	 */
	
	@RequestMapping(value = "/editarEmpresa/{id}", method = RequestMethod.GET)
	public ModelAndView editarEmpresa(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("editarEmpresa");
		Empresa empresa = empresaController.findById(id);
		mv.addObject("empresa", empresa);
		return mv;
	}
	
	@RequestMapping(value = "/editarEmpresa/{id}", method = RequestMethod.POST)
	public String editarNomeEmpresa(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
			return "redirect:/editarEmpresa/" + id;
		}
		
		Empresa empresa2 = empresaController.findById(id);
		
		if (empresa2.getNome() != empresa.getNome()) {
			empresa2.setNome(empresa.getNome());
		}
		
		empresaController.save(empresa2);
		
		return "redirect:/menuEmpresa/" + id;
	}
}
