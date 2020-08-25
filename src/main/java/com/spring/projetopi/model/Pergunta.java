package com.spring.projetopi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERGUNTA")
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long pergunta_id;
	
	@NotBlank(message = "Pergunta e obrigatorio")
	@Getter @Setter private String pergunta;
}
