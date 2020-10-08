package com.spring.projetopi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.projetopi.controller.ColaboradorController;
import com.spring.projetopi.controller.EmpresaController;
import com.spring.projetopi.model.Colaborador;
import com.spring.projetopi.model.Empresa;

@Controller
public class IndexService {

	@Autowired
	ColaboradorController colaboradorService;
	
	@Autowired
	EmpresaController empresaService;
	
    @RequestMapping(value = "/")
    public String GoToIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String verifyLoginColab(RedirectAttributes attributes, String email, String senha) {
    	String id = email;
    	String id2 = senha;
        
    	List<Colaborador> colaboradores = colaboradorService.findAll();
        
        List<Empresa> empresas = empresaService.findAll();
        
        for(int i = 0; i < colaboradores.size(); i++) {
        	
        	if(id.equals(colaboradores.get(i).getEmail()) && id2.equals(colaboradores.get(i).getSenha())) {
                long id4 = colaboradores.get(i).getColaborador_id();
        		return "redirect:/menuColaborador/" + id4;
        	}
        	
        }

        for(int i = 0; i < empresas.size(); i++) {
        	
        	if(id.equals(empresas.get(i).getEmail()) && id2.equals(empresas.get(i).getSenha())) {
        		long id3 = empresas.get(i).getEmpresa_id();
                return "redirect:/menuEmpresa/" + id3;
        	}
        	
        }
        
        attributes.addFlashAttribute("mensagem", "Por favor, confira se os dados estão corretos e tente novamente!");
        return "redirect:/";
    }
}
