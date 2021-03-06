package com.spring.projetopi.controller.controllerImpl;

import com.spring.projetopi.model.Questao;
import com.spring.projetopi.controller.QuestaoController;
import com.spring.projetopi.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoControllerImpl implements QuestaoController {

	@Autowired
	QuestaoRepository questaoRepository;
	
	@Override
	public List<Questao> findAll() {
		return questaoRepository.findAll();
	}

	@Override
	public Questao findById(long id) {
		return questaoRepository.findById(id).get();
	}

	@Override
	public Questao save(Questao questao) {
		return questaoRepository.save(questao);
	}
	
}