package com.spring.projetopi.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "REALIZACAOPESQUISA")
public class RealizacaoPesquisa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long realizacaopesquisa_id;
	
	@NotBlank
	@OneToOne
	@Getter @Setter private Colaborador colaborador;
	
	@NotBlank
	@OneToOne
	@Getter @Setter private Pesquisa pesquisa;
	
	@NotBlank
	@Getter @Setter private int acertos;
}
