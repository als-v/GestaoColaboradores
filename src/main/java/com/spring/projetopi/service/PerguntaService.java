package com.spring.projetopi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String savePergunta(@PathVariable("id") Long id, @RequestParam("pergunta1") String perguntaa1, @RequestParam("pergunta2") String perguntaa2, RedirectAttributes attributes) {
		System.out.println(perguntaa1);
		System.out.println(perguntaa2);
		
		if(perguntaa1 == "" || perguntaa2 == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
			return "redirect:/cadastroPergunta/" + id;
		}
		
		Pergunta pergunta1 = new Pergunta();
		
		pergunta1.setPergunta(perguntaa1);

		perguntaController.save(pergunta1);

		Pergunta pergunta2 = new Pergunta();
		
		pergunta2.setPergunta(perguntaa2);
		
		perguntaController.save(pergunta2);
		
		
		return "redirect:/cadastroAlternativa/" + id + "/" + pergunta1.getPergunta_id() + "/" + pergunta2.getPergunta_id();
	}
}
