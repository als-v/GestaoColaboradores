package com.spring.projetopi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.controller.AlternativaController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.controller.PerguntaController;
import com.spring.projetopi.controller.PesquisaController;
import com.spring.projetopi.controller.QuestaoController;
import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.model.Pergunta;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.Questao;


@Controller
public class AlternativaService {
	
	@Autowired
	AlternativaController alternativaController;
	
	@Autowired
	QuestaoController questaoController;
	
	@Autowired
	PerguntaController perguntaController;
	
	@Autowired
	PesquisaController pesquisaController;
	
	@Autowired
	EmpresaController empresaController;
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}", method = RequestMethod.GET)
	public ModelAndView getAlternativa() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(1);
		mv.addObject("a", a);
		return mv;
	}

	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}", method = RequestMethod.GET)
	public ModelAndView getAlternativa2() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(2);
		mv.addObject("a", a);
		return mv;
	}
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}", method = RequestMethod.GET)
	public ModelAndView getAlternativa3() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(3);
		mv.addObject("a", a);
		return mv;
	}	
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}/{id6}", method = RequestMethod.GET)
	public ModelAndView getAlternativa4() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(4);
		mv.addObject("a", a);
		return mv;
	}		

	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}", method = RequestMethod.GET)
	public ModelAndView getAlternativa5() {
		ModelAndView mv = new ModelAndView("cadastroAlternativa");
		Alternativa a = new Alternativa();
		a.setAlternativa(5);
		mv.addObject("a", a);
		return mv;
	}		
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}", method = RequestMethod.POST)
	public String saveAlternativa(Alternativa a, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3) {

		if(a.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		a.setAlternativa(1);
		
		alternativaController.save(a);
		
		System.out.println(a.getAlternativa());
		System.out.println(a.getDescricao());
		System.out.println(a.isCorreto());
		System.out.println(a.getAlternativa_id());
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + id3 + "/" + a.getAlternativa_id();
	}	
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}", method = RequestMethod.POST)
	public String saveAlternativa2(Alternativa b, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3, @PathVariable("id4") Long id4) {

		if(b.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		b.setAlternativa(2);
		
		alternativaController.save(b);
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + id3 + "/" + id4 + "/" + b.getAlternativa_id();
	}
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}", method = RequestMethod.POST)
	public String saveAlternativa3(Alternativa c, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3, @PathVariable("id4") Long id4, @PathVariable("id5") Long id5) {

		if(c.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		c.setAlternativa(3);
		
		alternativaController.save(c);
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + id3 + "/" + id4 + "/" + id5 + "/" + c.getAlternativa_id();
	}	
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}/{id6}", method = RequestMethod.POST)
	public String saveAlternativa4(Alternativa d, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3, @PathVariable("id4") Long id4, @PathVariable("id5") Long id5, @PathVariable("id6") Long id6) {

		if(d.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		d.setAlternativa(4);
		
		alternativaController.save(d);
		
		return "redirect:/cadastroAlternativa/" + id + "/" + id2 + "/" + id3 + "/" + id4 + "/" + id5 + "/" + id6+ "/" + d.getAlternativa_id();
	}
	
	@RequestMapping(value = "/cadastroAlternativa/{id}/{id2}/{id3}/{id4}/{id5}/{id6}/{id7}", method = RequestMethod.POST)
	public String saveAlternativa7(Alternativa e, RedirectAttributes attributes, @PathVariable("id") Long id, @PathVariable("id2") Long id2, @PathVariable("id3") Long id3, @PathVariable("id4") Long id4, @PathVariable("id5") Long id5, @PathVariable("id6") Long id6, @PathVariable("id7") Long id7) {

		if(e.getDescricao() == "") {
			attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
		}
		
		e.setAlternativa(5);
		
		alternativaController.save(e);
		
		Questao q = new Questao();
		
		q.setPergunta(perguntaController.findById(id3));
		
		List <Alternativa> alternativas = new ArrayList<Alternativa>();
		
		Pergunta nome = perguntaController.findById(id2);
		
		Alternativa a = alternativaController.findById(id4);
		Alternativa b = alternativaController.findById(id5);
		Alternativa c = alternativaController.findById(id6);
		Alternativa d = alternativaController.findById(id7);

		alternativas.add(a);
		alternativas.add(b);
		alternativas.add(c);
		alternativas.add(d);
		alternativas.add(e);
		
		
		q.setAlternativas(alternativas);
		
		questaoController.save(q);
		
		List<Questao> questoes = new ArrayList<Questao>();
		questoes.add(q);
		
		Pesquisa p1 = new Pesquisa();
		p1.setEmpresa(empresaController.findById(id));
		
		p1.setQuestoes(questoes);
		
		p1.setNome(nome.getPergunta());
		
		pesquisaController.save(p1);
		
		return "redirect:/menuEmpresa/" + id;
	}
	
}
