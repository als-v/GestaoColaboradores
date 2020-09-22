package com.spring.projetopi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.service.PerguntaService;

@Controller
public class PerguntaController {

	@Autowired
	PerguntaService perguntaService;
	
	@RequestMapping(value = "/cadastroPergunta/{id}", method = RequestMethod.GET)
	public String getPergunta() {
		return "cadastroPergunta";
	}
	
	@RequestMapping(value = "/cadastroPergunta/{id}", method = RequestMethod.POST)
	public String savePergunta(@PathVariable("id") Long id, String pergunta, RedirectAttributes attributes) {
		if(pergunta == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
			return "redirect:/cadastroPergunta/" + id;
		}
		
		Pergunta pergunta1 = new Pergunta();
		
		pergunta1.setPergunta(pergunta);

		perguntaService.save(pergunta1);
		
		
		return "redirect:/cadastroAlternativa/" + id + "/" + pergunta1.getPergunta_id();
	}
}
