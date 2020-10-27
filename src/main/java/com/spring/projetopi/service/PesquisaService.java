package com.spring.projetopi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.controller.PesquisaController;
import com.spring.projetopi.controller.RealizacaoPesquisaController;
import com.spring.projetopi.model.Alternativa;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;
import com.spring.projetopi.model.Pesquisa;
import com.spring.projetopi.model.RealizacaoPesquisa;

@Controller
public class PesquisaService {
	
	@Autowired
	EmpresaController empresaController;

	@Autowired
	PesquisaController pesquisaController;
	
	@Autowired
	ColaboradorController colaboradorController;
	
	@Autowired
	RealizacaoPesquisaController realizacaoPesquisaController;
	
	@RequestMapping(value = "/pesquisas/{id}", method = RequestMethod.GET)
	public ModelAndView getPesquisas(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pesquisa");
		List<Pesquisa> pesquisas = pesquisaController.findAll();
		
		for(int i = 0; i < pesquisas.size(); i++) {
			if(pesquisas.get(i).getEmpresa().getEmpresa_id() != id) {
				pesquisas.remove(i);
				i = -1;
			}
		}
		
		mv.addObject("pesquisas", pesquisas);
		
		return mv;
	}	
	
	@RequestMapping(value = "/realizarPesquisa/{id}", method = RequestMethod.GET)
	public ModelAndView getColaboradorPesquisas(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pesquisaColaborador");
		List<Pesquisa> pesquisas = pesquisaController.findAll();
		Colaborador colab = colaboradorController.findById(id);
		
		for(int i = 0; i < pesquisas.size(); i++) {
			if(pesquisas.get(i).getEmpresa().getEmpresa_id() != colab.getEmpresa().getEmpresa_id()) {
				pesquisas.remove(i);
				i = -1;
			}
		}
		
		mv.addObject("pesquisas", pesquisas);
		
		return mv;
	}
	
	@RequestMapping(value = "/realizarPesquisa/{id}", method = RequestMethod.POST)
	public String makeColaboradorPesquisas(RedirectAttributes attributes, @PathVariable("id") Long id) {
		Pesquisa pesquisa = realizacaoPesquisaController.getPesquisa(colaboradorController.findById(id));
		
		if(pesquisa != null) {
			return "redirect:pesquisa/" + id + "/" + pesquisa.getPesquisa_id();			
		}
		attributes.addFlashAttribute("mensagem", "Você já fez todos as pesquisas!");
		
		return "redirect:/realizarPesquisa/" + id;
	}
	
	@RequestMapping(value = "/realizarPesquisa/pesquisa/{id1}/{id2}", method = RequestMethod.GET)
	public ModelAndView getResultPesquisa(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
		ModelAndView mv = new ModelAndView("fazerPesquisa");
		Pesquisa pesquisa = pesquisaController.findById(id2);
		
		mv.addObject("pesquisa", pesquisa);
		
		return mv;
	}
	
	@RequestMapping(value = "/realizarPesquisa/pesquisa/{id1}/{id2}", method = RequestMethod.POST)
	public String resultPesquisa(@RequestParam("teste") List<Boolean> Alternativas, @PathVariable("id1") Long id1, @PathVariable("id2") Long id2) {
		Colaborador colaborador = colaboradorController.findById(id1);
		Pesquisa pesquisa = pesquisaController.findById(id2);
		RealizacaoPesquisa realizacaoPesquisa = new RealizacaoPesquisa();
		
		realizacaoPesquisa.setColaborador(colaborador);
		realizacaoPesquisa.setPesquisa(pesquisa);

		List<Boolean> check = realizacaoPesquisaController.checkValues(Alternativas);

		List<Integer> result = realizacaoPesquisaController.calcAcertos(pesquisa, check);
		
		realizacaoPesquisa.setAcertos(result.get(0));
		realizacaoPesquisa.setErros(result.get(1));
		
		realizacaoPesquisaController.save(realizacaoPesquisa);
		
		return "redirect:/menuColaborador/" + id1;
	}
	
	@RequestMapping(value = "/menuColaborador/{id}", method = RequestMethod.POST)
	public String colabMenuPesquisa(@PathVariable("id") Long id, RedirectAttributes attributes) {
		Pesquisa pesquisa = realizacaoPesquisaController.getPesquisa(colaboradorController.findById(id));
		
		if(pesquisa != null) {
			return "redirect:/realizarPesquisa/pesquisa/" + id + "/" + pesquisa.getPesquisa_id();			
		}
		attributes.addFlashAttribute("mensagem", "Você já fez todos as pesquisas!");
		
		return "redirect:/menuColaborador/" + id;
	}
	
	@RequestMapping(value = "/visualizarResultadosEmpresa/{id}", method = RequestMethod.GET)
	public ModelAndView resultPesquisa(@PathVariable("id") Long id) {
		System.out.println(id);
		ModelAndView mv = new ModelAndView("visualizarResultadoEmpresa");
		
		Empresa empresa = empresaController.findById(id);
		List<RealizacaoPesquisa> pesquisas = realizacaoPesquisaController.findAll();
		List<RealizacaoPesquisa> empresa_pesquisa = new ArrayList<RealizacaoPesquisa>();
		
		for(int i = 0; i < pesquisas.size(); i++) {
			if(pesquisas.get(i).getColaborador().getEmpresa() == empresa) {
				empresa_pesquisa.add(pesquisas.get(i));
			}
		}
		
		mv.addObject("pesquisas", empresa_pesquisa);
		
		return mv;
	}
}
