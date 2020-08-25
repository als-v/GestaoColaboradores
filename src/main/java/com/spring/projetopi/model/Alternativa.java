package com.spring.projetopi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ALTERNATIVA")
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long alternativa_id;
	
	@NotBlank(message = "E necessario ter uma alternativa")
	@Getter @Setter private int alternativa;
	
	@NotBlank(message = "E necessario ter uma descricao")
	@Getter @Setter private String descricao;
	
	@NotBlank(message = "E necessario informar se esta certa ou nao")
	@Getter @Setter private boolean correto;
}
