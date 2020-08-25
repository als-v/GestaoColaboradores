package com.spring.projetopi.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "QUESTAO")
public class Questao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long questao_id;

	@OneToOne
	@Getter @Setter private Pergunta pergunta;
	
	@OneToMany
	@Getter @Setter private List<Alternativa> alternativas;
}
