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

import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;

@Controller
public class ColaboradorService {

	@Autowired
	ColaboradorController colaboradorController;
	
	@Autowired
	EmpresaController empresaController;

	@RequestMapping(value = "/colaboradores", method = RequestMethod.GET)
	public ModelAndView getEmpresa() {
		ModelAndView mv = new ModelAndView("colaboradores");
		List<Colaborador> colaboradores = colaboradorController.findAll();
		mv.addObject("colaboradores", colaboradores);
		return mv;
	}
	
	@RequestMapping(value = "/colaboradores/{id}", method = RequestMethod.GET)
	public ModelAndView getColaboradores(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("colaboradores");
		List<Colaborador> colaboradores = empresaController.findColaborador(id);
		mv.addObject("colaboradores", colaboradores);
		return mv;
	}
	
	@RequestMapping(value = "/cadastroColaborador/{id}", method = RequestMethod.GET)
	public String GoToCadastro() {
	    return "cadastroColaborador";
	}
	
	@RequestMapping(value = "/cadastroColaborador/{id}", method = RequestMethod.POST)
	public String saveColaborador(Colaborador colaborador, RedirectAttributes attributes, @PathVariable("id") Long id) {
		if (colaborador.getEmail() == "" || colaborador.getSenha() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
			return "redirect:/cadastroColaborador/" + id;
		}
		
		if (!colaboradorController.verifyEmailEmpresa(colaborador.getEmail())) {
			attributes.addFlashAttribute("mensagem", "E-mail já cadastrado no sistema, por favor tente novamente!");
			return "redirect:/cadastro";
		}
		
		Empresa emp = empresaController.findById(id);
		
		colaborador.setEmpresa(emp);
		
		colaboradorController.save(colaborador);
		
		return "redirect:/menuEmpresa/" + id;
	}
	
	@RequestMapping(value = "/editarColaborador/{id}", method = RequestMethod.GET)
	public String editarColaborador(@PathVariable("id") Long id) {
		return "editarColaborador";
	}
	
	/*
	@RequestMapping(value = "/editarColaborador/{id}", method = RequestMethod.GET)
	public ModelAndView editarColaborador(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("editarColaborador");
		Colaborador colaborador = colaboradorController.findById(id);
		mv.addObject("colaborador", colaborador);
		return mv;
	}
	
	
	@RequestMapping(value = "/editarColaborador/{id}", method = RequestMethod.POST)
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
	*/
}
