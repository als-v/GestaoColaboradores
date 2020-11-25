package com.spring.projetopi.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "realizacaopesquisa")
public class RealizacaoPesquisa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="realizacaopesquisa_id", updatable = false, nullable = false)
	@Getter @Setter private long realizacaopesquisa_id;
	
	@NotNull
	@OneToOne
	@Getter @Setter private Colaborador colaborador;
	
	@NotNull
	@OneToOne
	@Getter @Setter private Pesquisa pesquisa;
	
	@Column(name="acertos", nullable = false)
	@Getter @Setter private int acertos;
	
	@Column(name="erros", nullable = false)
	@Getter @Setter private int erros;
	
	@Column(name="porcentagemAcerto", nullable = false)
	@Getter @Setter private float porcentagemAcerto;
	
	@Column(name="porcentagemErro", nullable = false)
	@Getter @Setter private float porcentagemErro;
}
