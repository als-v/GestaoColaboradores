package com.spring.projetopi.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questao")
public class Questao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="questao_id", updatable = false, nullable = false)
	@Getter @Setter private long questao_id;

	@OneToOne
	@Column(name="pergunta", nullable = false)
	@Getter @Setter private Pergunta pergunta;
	
	@OneToMany
	@Getter @Setter private List<Alternativa> alternativas;
}
