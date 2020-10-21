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
	ColaboradorController colaboradorController;
	
	@Autowired
	EmpresaController empresaController;
	
    @RequestMapping(value = "/")
    public String GoToIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String verifyLoginColab(RedirectAttributes attributes, String email, String senha) {
    	long empresaLogin = empresaController.loginEmpresa(email, senha);
    	long colaboradorLogin = colaboradorController.loginColaborador(email, senha);
    	
    	if((empresaLogin != -1 && empresaLogin != -2) && colaboradorLogin == -1) {
    		return "redirect:/menuEmpresa/" + empresaLogin;
    	} else if (empresaLogin == -1 && (colaboradorLogin != -1 && colaboradorLogin != -2)) {
    		return "redirect:/menuColaborador/" + colaboradorLogin;
    	} else if(empresaLogin == -2 || colaboradorLogin == -2){
    		attributes.addFlashAttribute("mensagem", "Senha incorreta, por favor tente novamente");
    		return "redirect:/";
    	} else {
    		attributes.addFlashAttribute("mensagem", "Erro, os dados informados não estão cadastrados no sistema! Por favor tente novamente");
    		return "redirect:/";
    	}
    }
}
