package com.spring.projetopi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.service.ColaboradorService;

@Controller
public class ColaboradorController {

	@Autowired
	ColaboradorService colaboradorService;

	@RequestMapping(value = "/colaboradores", method = RequestMethod.GET)
	public ModelAndView getEmpresa() {
		ModelAndView mv = new ModelAndView("colaboradores");
		List<Colaborador> colaboradores = colaboradorService.findAll();
		mv.addObject("colaboradores", colaboradores);
		return mv;
	}
}
