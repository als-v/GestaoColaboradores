package com.spring.projetopi.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.Questao;
import com.spring.projetopi.service.AlternativaService;
import com.spring.projetopi.service.EmpresaService;
import com.spring.projetopi.service.PerguntaService;
import com.spring.projetopi.service.PesquisaService;
import com.spring.projetopi.service.QuestaoService;

@Controller
public class AlternativaController {
	
	@Autowired
	AlternativaService alternativaService;
	
	@Autowired
	QuestaoService questaoService;
	
	@Autowired
	PerguntaService perguntaService;
	
	@Autowired
	PesquisaService pesquisaService;
	
	@Autowired
	EmpresaService empresaService;
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}", method = RequestMethod.GET)
	public ModelAndView getAlternativa() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(1);
		mv.addObject("a", a);
		return mv;
	}

	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}", method = RequestMethod.GET)
	public ModelAndView getAlternativa2() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(2);
		mv.addObject("a", a);
		return mv;
	}
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}", method = RequestMethod.GET)
	public ModelAndView getAlternativa3() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(3);
		mv.addObject("a", a);
		return mv;
	}	
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}", method = RequestMethod.GET)
	public ModelAndView getAlternativa4() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(4);
		mv.addObject("a", a);
		return mv;
	}		

	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}/{id6}", method = RequestMethod.GET)
	public ModelAndView getAlternativa5() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(5);
		mv.addObject("a", a);
		return mv;
	}		
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}", method = RequestMethod.POST)
	public String saveAlternativa(Alternativa a, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2) {

		if(a.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		a.setAlternativa(1);
		
		alternativaService.save(a);
		
		System.out.println(a.getAlternativa());
		System.out.println(a.getDescricao());
		System.out.println(a.isCorreto());
		System.out.println(a.getAlternativa_id());
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + a.getAlternativa_id();
	}	
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}", method = RequestMethod.POST)
	public String saveAlternativa2(Alternativa b, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3) {

		if(b.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		b.setAlternativa(2);
		
		alternativaService.save(b);
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + id3 + "/" + b.getAlternativa_id();
	}
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}", method = RequestMethod.POST)
	public String saveAlternativa3(Alternativa c, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3, @PathVariable("id4") Long id4) {

		if(c.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		c.setAlternativa(3);
		
		alternativaService.save(c);
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + id3 + "/" + id4 + "/" + c.getAlternativa_id();
	}	
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}", method = RequestMethod.POST)
	public String saveAlternativa4(Alternativa d, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3, @PathVariable("id4") Long id4, @PathVariable("id5") Long id5) {

		if(d.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		d.setAlternativa(4);
		
		alternativaService.save(d);
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + id3 + "/" + id4 + "/" + id5 + "/" + d.getAlternativa_id();
	}
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}/{id6}", method = RequestMethod.POST)
	public String saveAlternativa5(Alternativa e, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3, @PathVariable("id4") Long id4, @PathVariable("id5") Long id5, @PathVariable("id6") Long id6) {

		if(e.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		e.setAlternativa(5);
		
		alternativaService.save(e);
		
		Questao q = new Questao();
		
		q.setPergunta(perguntaService.findById(id2));
		
		List <Alternativa> alternativas = new ArrayList<Alternativa>();
		
		Alternativa a = alternativaService.findById(id3);
		Alternativa b = alternativaService.findById(id4);
		Alternativa c = alternativaService.findById(id5);
		Alternativa d = alternativaService.findById(id6);
		
		alternativas.add(a);
		alternativas.add(b);
		alternativas.add(c);
		alternativas.add(d);
		alternativas.add(e);
		
		
		q.setAlternativas(alternativas);
		
		questaoService.save(q);
		
		List<Questao> questoes = new ArrayList<Questao>();
		questoes.add(q);
		
		Pesquisa p1 = new Pesquisa();
		p1.setEmpresa(empresaService.findById(id));
		
		p1.setQuestoes(questoes);
		
		p1.setNome("Pesquisa sem nome");
		
		pesquisaService.save(p1);
		
		return "redirect:/menuEmpresa/" + id;
	}	
}
