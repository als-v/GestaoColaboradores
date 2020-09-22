package com.spring.projetopi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ALTERNATIVA")
public class Alternativa {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long alternativa_id;
	
	@NotNull
	@Getter @Setter private int alternativa;
	
	@NotBlank(message = "E necessario ter uma descricao")
	@Getter @Setter private String descricao;
	
	@NotNull
	@Getter @Setter private boolean correto;
}
