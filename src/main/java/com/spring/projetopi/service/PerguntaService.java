package com.spring.projetopi.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.controller.PerguntaController;
import com.spring.projetopi.model.Pergunta;

@Controller
public class PerguntaService {

	@Autowired
	PerguntaController perguntaController;
	
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

		perguntaController.save(pergunta1);
		
		
		return "redirect:/cadastroAlternativa/" + id + "/" + pergunta1.getPergunta_id();
	}
}
