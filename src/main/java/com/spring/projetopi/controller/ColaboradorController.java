package com.spring.projetopi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.service.ColaboradorService;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.service.EmpresaService;

@Controller
public class ColaboradorController {

	@Autowired
	ColaboradorService colaboradorService;
	
	@Autowired
	EmpresaService empresaService;

	@RequestMapping(value = "/colaboradores", method = RequestMethod.GET)
	public ModelAndView getEmpresa() {
		ModelAndView mv = new ModelAndView("colaboradores");
		List<Colaborador> colaboradores = colaboradorService.findAll();
		mv.addObject("colaboradores", colaboradores);
		return mv;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/colaboradores/{id}", method = RequestMethod.GET)
	public ModelAndView getColaboradores(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("colaboradores");
		List<Colaborador> colaboradores = colaboradorService.findAll();
		
		for(int i = 0; i < colaboradores.size(); i++) {
			if(colaboradores.get(i).getEmpresa().getEmpresa_id() != id) {
				colaboradores.remove(i);
				i = -1;
			}
		}
		
		mv.addObject("colaboradores", colaboradores);
		return mv;
	}	
	
	@RequestMapping(value = "/cadastroColaborador/{id}", method = RequestMethod.GET)
	public String GoToCadastro() {
	    return "cadastroColaborador";
	}
	
	@RequestMapping(value = "/cadastroColaborador/{id}", method = RequestMethod.POST)
	public String saveColaborador(@Valid Colaborador colaborador, BindingResult result, RedirectAttributes attributes, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
			return "redirect:/cadastroColaborador/" + id;
		}
		
		Empresa emp = empresaService.findById(id);
		colaborador.setEmpresa(emp);
		
		colaboradorService.save(colaborador);
		
		return "redirect:/menuEmpresa/" + id;
	}
}
